/* Write a program that:
1) if args size < 3, calls main (args: Array < String >) with the args input argument. args contains three elements: first, second, and third;

2) otherwise prints args elements - each on a new line. */
fun main(args: Array<String>) {
    if(args.size < 3) {
        main(arrayOf("first", "second", "third"))
    } else {
        for(arg in args) {
            println(arg)
        }
    }
}
