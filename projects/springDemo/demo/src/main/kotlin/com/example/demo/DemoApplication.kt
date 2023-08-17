package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import java.util.UUID
import org.springframework.jdbc.core.query
import org.springframework.web.bind.annotation.*


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

data class ControlRequest(val switch: String)

@RestController
@RequestMapping("/control")
class ControlController(val service: ControlService) {
	@PostMapping
	fun control(@RequestBody request: ControlRequest): String {
		if (request.switch == "on") {
			// Control logic here
			service.turnOnLed()
			return "Switch is ON"
		} else {
			return "Invalid request"
		}
	}
}

class MessageController(val service: MessageService) {
	@GetMapping("/")
	fun index(): List<Message> = service.findMessages()

	@GetMapping("/{id}")
	fun index(@PathVariable id: String): List<Message> =
		service.findMessageById(id)

	@PostMapping("/")
	fun post(@RequestBody message: Message) {
		service.save(message)
	}
}

data class Message(val id: String?, val text: String)

@Service
class MessageService(val db: JdbcTemplate) {

	fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
		Message(response.getString("id"), response.getString("text"))
	}

	fun findMessageById(id: String): List<Message> = db.query("select * from messages where id = ?", id) { response, _ ->
		Message(response.getString("id"), response.getString("text"))
	}

	fun save(message: Message) {
		val id = message.id ?: UUID.randomUUID().toString()
		db.update("insert into messages values ( ?, ? )",
			id, message.text)
	}
}

@Service
class ControlService() {
	fun turnOnLed() {
		println("Attempting to turn ON LED on pi Remotely")
		val result = ProcessBuilder("ssh", "<pi host>", "sudo", "python3", "/home/<user>/flash_single_led.py")
		.redirectOutput(ProcessBuilder.Redirect.INHERIT)
		.redirectError(ProcessBuilder.Redirect.INHERIT)
		.start()
		.waitFor()
		assert(result == 0)
		TODO()// remove hard coding and parameterize
	}
}