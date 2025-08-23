/*
//The Unit type:
//It's optional to specify the Unit return type
// in Kotlin. For functions that don't return
// anything, or returning Unit,
// you don't need a return statement.

//1
fun main() {
    birthdayGreeting()
}

fun birthdayGreeting(): Unit {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}
//2
fun main() {
    birthdayGreeting()
}

fun birthdayGreeting() {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}
*/


/*
//Return a String from birthdayGreeting()
fun main() {
    val greeting = birthdayGreeting()
    println(greeting)
}
fun birthdayGreeting(): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
*/


/*
***  Functions with multiple parameters

fun main() {
    println(birthdayGreeting("Ayse", 22))
    println((birthdayGreeting("Firat", 25)))
}
//Add a parameter to the birthdayGreeting() function
fun birthdayGreeting(name: String, age: Int) : String {
    val nameGreeting = "Happy Birthday $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}
*/


/*
// Named arguments
fun main() {
    println(birthdayGreeting(name = "Ayse", age = 22))
    println((birthdayGreeting(age = 25, name = "FIRAT")))
}
//Add a parameter to the birthdayGreeting() function
fun birthdayGreeting(name: String, age: Int) : String {
    val nameGreeting = "Happy Birthday $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}
*/



/*
//Default arguments
fun main () {
    println(birthdayGreeting(age = 22))
    println(birthdayGreeting("Firat", 25))

}

fun birthdayGreeting(name: String = "Ayse", age: Int) : String {
    return "$name is $age years old"
}

*/



/*
//Practise: String templates
fun main() {
    var discountPercentage = 0
    val offer: String
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"

    println(offer)
}

 */



/*
//Practise: String concatenation


fun main() {
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}
*/



/*
//Practise: Message formatting

fun main() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = "${baseSalary + bonusAmount}"
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")

}
 */



/*
//Practise: Implement basic math operations
fun main() {
    val firstNumber = 10
    val secondNumber = 5

    println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
}




fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

    val subResult = subtract(firstNumber, secondNumber)
    val anotherSubResult = subtract(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")

    println("$firstNumber - $secondNumber = $subResult")
    println("$firstNumber - $thirdNumber = $anotherSubResult")

}

fun add(firstNum: Int, secondNum: Int): Int {
    return firstNum + secondNum
}

fun subtract(firstNum: Int, secondNum: Int): Int {
    return firstNum - secondNum
}

 */



/*
//Practise: Default parameters

fun main() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
    println(displayAlertMessage(emailId = emailId))
}

fun displayAlertMessage(operSystName: String = "Unknown", emailId: String): String {
    val message = "There's a new sign-in request on $operSystName for your Google Account $emailId.\n"
    return message
}

 */



/*
// Practise: Compare two numbers
fun main() {
    val timeSpentToday = 300
    val timeSpentYesterday = 200

    println(timeSpentCalculator(timeSpentToday, timeSpentYesterday))
}
fun timeSpentCalculator(today: Int, yesterday: Int) : Boolean {
    return today > yesterday
}

 */





// Practise: Move duplicate code into a function
fun main() {
    displayWeather("Ankara", 27, 31)
    displayWeather("Tokyo", 32, 36)
}

fun displayWeather(city: String, lowTemp: Int, highTemp: Int){
    println("City: $city")
    println("Low temp: $lowTemp")
    println("High temp: $highTemp")
}












