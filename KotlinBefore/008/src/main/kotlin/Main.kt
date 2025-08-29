/* =============================================================
 * 1. Fonksiyonu değişkende saklamak (hatalı atama)
 * -------------------------------------------------------------
 * trick fonksiyonunu parantezsiz olarak değişkene atamaya çalışmak
 * derleyicide "Function invocation 'trick()' expected" hatasına yol açar.
 * =============================================================

fun main() {
    val trickFunction = trick
}

fun trick() {
    println("No treats!")
}

*/

/* =============================================================
 * 2. Fonksiyonu referans operatörü (::) ile saklamak
 * --------------------------------------------------
 * Fonksiyon referansı (::trick) kullanılarak hatasız atama yapılır.
 * =============================================================

fun main() {
    val trickFunction = ::trick
}

fun trick() {
    println("No treats!")
}

*/

/* =============================================================
 * 3. Lambda ifadesiyle fonksiyon tanımlamak
 * ----------------------------------------
 * trick artık bir değişken; fonksiyon gövdesi lambda ifadesidir.
 * =============================================================

fun main() {
    val trickFunction = trick
}

val trick = {
    println("No treats!")
}

*/

/* =============================================================
 * 4. Lambda ve değişken üzerinden fonksiyonu çağırmak
 * --------------------------------------------------
 * Hem trick() hem de trickFunction() çağrıları aynı çıktıyı üretir.
 * =============================================================

fun main() {
    val trickFunction = trick
    trick()
    trickFunction()
}

val trick = {
    println("No treats!")
}

*/

/* =============================================================
 * 5. İkinci lambda (treat) eklemek
 * --------------------------------
 * treat fonksiyonu eklenir ve çağrılır.
 * =============================================================

fun main() {
    val trickFunction = trick
    trick()
    trickFunction()
    treat()
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

/* =============================================================
 * 6. Fonksiyon döndüren higher‑order fonksiyon
 * -------------------------------------------
 * trickOrTreat, Boolean parametreye göre fonksiyon döndürür.
 * =============================================================

fun main() {
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

/* =============================================================
 * 7. Fonksiyonu argüman olarak geçmek (extraTreat)
 * -----------------------------------------------
 * coins ve cupcake lambdaları extraTreat parametresi olarak verilir.
 * =============================================================

fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

/* =============================================================
 * 8. Nullable function type kullanımı
 * -----------------------------------
 * extraTreat nullable yapılır ve null geçirilebilir.
 * =============================================================

fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

/* =============================================================
 * 9. Tek parametre için it kısaltması
 * ----------------------------------
 * coins lambda'sında quantity yerine it kullanılır.
 * =============================================================

fun main() {
    val coins: (Int) -> String = {
        "$it quarters"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

/* =============================================================
 * 10. Lambda'yı doğrudan fonksiyon çağrısına geçmek
 * -------------------------------------------------
 * coins değişkeni kaldırılır, lambda inline verilir.
 * =============================================================

fun main() {
    val treatFunction = trickOrTreat(false, { "$it quarters" })
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

/* =============================================================
 * 11. Trailing lambda syntax kullanımı
 * ------------------------------------
 * Lambda, fonksiyon çağrısındaki son parantezden sonra yazılır.
 * =============================================================

fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

*/

// =============================================================
// 12. repeat() higher‑order fonksiyon kullanımı (final örnek)
// -------------------------------------------------------------
// treatFunction 4 kez çağrılır, ardından trickFunction çalışır.
// =============================================================

fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}
