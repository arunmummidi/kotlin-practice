enum class RequestState(val message: String){
    SUCCESS("Request is successful"),
    PENDING("Request is pending"),
    ERROR("Request failed!");

    fun printStatus(){
        when(this) {
            SUCCESS -> println(this.message)
            PENDING -> println(this.message)
            ERROR -> println(this.message)
        }
    }

}
fun main() {
    var webRequestStatus = RequestState.SUCCESS
    webRequestStatus.printStatus()

    webRequestStatus = RequestState.PENDING
    webRequestStatus.printStatus()

}
