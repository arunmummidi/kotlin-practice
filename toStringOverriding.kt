/*You’ve developed a beautiful cross-platform application used by many people. As a developer, you want to know how it is doing: what errors occur, what devices your clients use, what operating systems they have installed, and so on. For this purpose, you've created the CustomerInfo class. In order to save all the necessary information in a convenient way, you want to create a method to send the information to the server and override toString() for it.

Override toString() to send information to the server as follows:

Id: val_uid; Operation System: val_operationSystem; RAM: val_ram; Core Speed: val_coreSpeed; Timestamp: val_timeStamp

where val_uid, val_operationSystem, val_ram, val_coreSpeed, and val_timeStamp are the values of the CustomerInfo properties.*/ties.*/

class CustomerInfo(
    /** Unique user id */
    val uid: String,
    /** Operation system: Windows, Linux, macOS, iOS */
    val operationSystem: String,
    /** In GB */
    val ram: Int,
    /** In GHz */
    val coreSpeed: Double,
    val timeStamp: Long
) {
// toString() function over ride to capture the properties of class instance for debugging
    override fun toString():String {
        return "Id: $uid; Operation System: $operationSystem; RAM: $ram; Core Speed: $coreSpeed; Timestamp: $timeStamp"
    }
}

fun sendCustomerInfoToServer(customer: CustomerInfo) {
    Server.send(customer.toString()) // this is an encapsulated class. Not shown to us.
}