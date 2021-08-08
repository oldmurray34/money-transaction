import kotlin.math.roundToInt

fun main() {
    val initialAmount: Int = 100000
    val cardTransactionRates: Double = 0.0075
    val minimumTransaction: Int = 3500

    if (initialAmount > minimumTransaction) {
        var amount = initialAmount - (initialAmount * cardTransactionRates)
        println("Перевод на сумму ${amount.roundToInt()} копеек совершен")
    } else {
        println("Сумма перевода должна быть больше 35 рублей")
    }
}