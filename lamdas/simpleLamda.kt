//Write a lambda expression that takes two integer arguments and returns the greatest of them.
val lambda: (Int, Int) -> Int = { a: Int, b: Int ->
    if (a > b) {
        a
    } else b
}