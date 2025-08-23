fun main() {
    //Variable Declaration
    val favoritesProgrammingLanguage: String = "Kotlin"
    println(favoritesProgrammingLanguage)

    //String template
    val messages: Int = 2
    println("You have $messages unread messages.")

    //Type Inference
    val count = 13
    println(count)

    //Basic math operations with integers
    val unreadCount = 5
    val readCount = 100
    println("You have ${unreadCount + readCount} total messages in your inbox.")


    //String Template
    val numberOfPhotos = 100
    val photosDeleted = 10
    println("$numberOfPhotos photos.")
    println("$photosDeleted deleted photos.")
    println("${numberOfPhotos - photosDeleted} photos left.")


    //Update variables
    var cartTotal = 0
    println("Total: $cartTotal")

    cartTotal = 20
    println("Total: $cartTotal")

    var countNew = 10
    println("You have $countNew unread messages.")
    countNew++
    println("You have $countNew unread messages.")






    //Explore other data types
    val trip1: Double = 3.20
    val trip2: Double = 4.10
    val trip3: Double = 1.72
    val totalTripLength: Double = trip1 + trip2 + trip3
    println("$totalTripLength miles left to destination")
    //Kotlin have type inference therefore I don't need to specify types.
    val tripp1 = 3.20
    val tripp2 = 4.10
    val tripp3 = 1.72
    val totalTrippLength = tripp1 + tripp2 + tripp3
    println("$totalTrippLength miles left to destination")
    //String
    val nextMeeting = "Next meeting: "
    val date = "January 1"
    val reminder = nextMeeting + date
    println(reminder)
    //Booelean
    val notificationsEnabled: Boolean = false
    println("Are notifications enabled? " + notificationsEnabled)




    //Comments
    /*
    * This program displays the number of messages
    * in the user's inbox.
    */
}