/*Duplication
Read the input string and duplicate it in the file MyFile.txt.*/

// Write your code here. Do not import any libraries
var text = readLine()!!
text = text + text
val fileName = "MyFile.txt"
val myFile = File(fileName)
myFile.writeText(text)