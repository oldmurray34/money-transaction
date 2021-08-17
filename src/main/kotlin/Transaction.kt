import kotlin.math.roundToInt

fun transactionRatesCalc(cardType: String = "Vk pay", previousTransactionsThisMonth: Int = 0, initialAmount: Int): Int {
    var result = 0
    if (cardType == "Vk pay") {
        result = if (previousTransactionsThisMonth + initialAmount >= 4_000_000 || initialAmount >= 1_500_000) {
            -1
        } else {
            initialAmount
        }
    } else if (cardType == "Visa" || cardType == "Мир") {
        result = if (previousTransactionsThisMonth + initialAmount >= 60_000_000 || initialAmount >= 15_000_000) {
            -1
        } else {
            (initialAmount - (initialAmount * 0.0075)).roundToInt()
        }
    } else if (cardType == "Mastercard" || cardType == "Maestro") {
        result = if (previousTransactionsThisMonth + initialAmount >= 60_000_000 || initialAmount >= 15_000_000) {
            -1
        } else if (initialAmount < 75_000) {
            initialAmount
        } else {
            (initialAmount - (initialAmount * 0.006) - 20).roundToInt()
        }
    }
    return result
}