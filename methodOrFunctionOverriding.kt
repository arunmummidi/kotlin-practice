private class Me: ActuallyMe() {
    override fun returnName(name: String): String = "My name is $name"
}

open class ActuallyMe {
    open fun returnName(name: String): String = "Actually, my name is $name"
}