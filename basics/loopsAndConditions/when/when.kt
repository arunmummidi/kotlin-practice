
//When statement

fun main() {
 val mercury = "Mercury"
 when (mercury) {
     "mercury" -> print(message = "Universe is intact")
     "Mercury" -> print(message = "Universe is still intact")
     else -> print(message = "Universe may be in danger")
 }

 var age = 40
 var hasAccess: Boolean = true
 when {
     age < 18 && hasAccess -> println("False positive")
     age > 21 && !hasAccess -> println("False negative")
     else -> println("All working as expected")
 }

 val maxSurfaceTempInK = 700
 when(maxSurfaceTempInK) {
     700 -> println("This is Mercury's maximum surface temperature") // 1
     0, 1, 2 -> println("It's as cold as it gets") // 2
     in 300..699 -> println("This temperature is also possible on Mercury") // 3
     !in 0..300 -> println("This is pretty hot") // 4
     is Int -> println("Given variable is of type Int") // 6
     else -> { // 7
         // You can also use blocks of code on the right hand side, like here
         println("Default case")
     }
 }
} 
[?1049h[22;0;0t[>4;2m[?1h=[?2004h[?1004h[1;38r[?12h[?12l[22;2t[22;1t[27m[23m[29m[m[H[2J[?25l[38;1H"../../basicsPractice.kt" 510L, 16071B[1;1H[4m[38;5;130m  1 [m[4m////When statement                                                                                                                                [m[2;1H[38;5;130m  2 [m//    val mercury = "Mercury"
[38;5;130m  3 [m//    when (mercury) {
[38;5;130m  4 [m//[8C"mercury" -> print(message = "Universe is intact")
[38;5;130m  5 [m//[8C"Mercury" -> print(message = "Universe is still intact")
[38;5;130m  6 [m//[8Celse -> print(message = "Universe may be in danger")
[38;5;130m  7 [m//    }
[38;5;130m  8 [m//
[38;5;130m  9 [m//    var age = 40
[38;5;130m 10 [m//    var hasAccess: Boolean = true
[38;5;130m 11 [m//    when {
[38;5;130m 12 [m//[8Cage < 18 && hasAccess -> println("False positive")
[38;5;130m 13 [m//[8Cage > 21 && !hasAccess -> println("False negative")
[38;5;130m 14 [m//[8Celse -> println("All working as expected")
[38;5;130m 15 [m//    }
[38;5;130m 16 [m//    val maxSurfaceTempInK = 700
[38;5;130m 17 [m//    when(maxSurfaceTempInK) {
[38;5;130m 18 [m//[8C700 -> println("This is Mercury's maximum surface temperature") // 1
[38;5;130m 19 [m//[8C0, 1, 2 -> println("It's as cold as it gets") // 2
[38;5;130m 20 [m//[8Cin 300..699 -> println("This temperature is also possible on Mercury") // 3
[38;5;130m 21 [m//[8C!in 0..300 -> println("This is pretty hot") // 4
[38;5;130m 22 [m//[8Cis Int -> println("Given variable is of type Int") // 6
[38;5;130m 23 [m//[8Celse -> { // 7
[38;5;130m 24 [m//[12C// You can also use blocks of code on the right hand side, like here
[38;5;130m 25 [m//[12Cprintln("Default case")
[38;5;130m 26 [m//[8C}
[38;5;130m 27 [m//    }
[38;5;130m 28 
 29 [m//    // For loops
[38;5;130m 30 [m//    val planets= arrayOf("earth", "venus", "neptune") //string arrays
[38;5;130m 31 [m//    for (i in 1 .. 5) println("hello")
[38;5;130m 32 [m//    for (i in 1 until 5) println("wow")
[38;5;130m 33 [m//    for (i in planets) println("$i")
[38;5;130m 34 
 35 [m////infix functions
[38;5;130m 36 [m//    val total = sum(1,3)
[38;5;130m 37 [m//    println(total)[38;133H1,1[11CTop[1;5H[?25h[?25l[38;1HType  :qa  and press <Enter> to exit Vim[38;133H[K[38;133H1,1[11CTop[1;5H[?25h[?25l[1;37r[1;1H[18M[1;38r[1;1H[4m[38;5;130m 19 [m[4m//        0, 1, 2 -> println("It's as cold as it gets") // 2                                                                                      [m[20;1H[38;5;130m 38 [m//    val str1 = "Hello"
[38;5;130m 39 [m//    val str2 = "Hello"
[38;5;130m 40 [m//    val result = str1 arun_fun str2
[38;5;130m 41 [m//    println(result)
[38;5;130m 42 
 43 
 44 [m////Collections
[38;5;130m 45 [m//    val immutablelist = listOf("arun", "ramu")
[38;5;130m 46 [m//    println(immutablelist[0])
[38;5;130m 47 [m//
[38;5;130m 48 [m//    val mutablelist = mutableListOf("goa", "Khatmandu")
[38;5;130m 49 [m//    println(mutablelist[0])
[38;5;130m 50 [m//    mutablelist.add("Ranchi")
[38;5;130m 51 [m//    println(mutablelist)
[38;5;130m 52 [m//
[38;5;130m 53 [m//    val immutableset = setOf("earth", "moon", "mercury", "mercury") //duplicates are ignored
[38;5;130m 54 [m//    println(immutableset)
[38;5;130m 55 [m//[38;1H[K[38;133H19,1[11C3%[1;5H[?25h[?25l[10C[4m-1, 1, 2 -> println("It's as cold as it gets") // 2[m[38;137H2[1;16H[?25h[?25l[38;1HType  :qa!  and press <Enter> to abandon all changes and exit Vim[38;133H[K[38;133H19,12[10C3%[1;16H[?25h[?25l[38;133H[K[38;133H19,12[10C3%[1;16H[?25h[?25l[38;133H[K[38;133H19,12[10C3%[1;16H[?25h[?25l[38;133H[K[38;133H19,12[10C3%[1;16H[?25h[?25l[38;133H[K[38;133H19,12[10C3%[1;16H[?25h[38;1H
[?1004l[?2004l[?1l>[>4;m[?1049l[23;0;0t