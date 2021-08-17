import org.junit.Test
import org.junit.Assert.*

class TransactionKtTest {

    @Test
    fun transactionRatesCalcVisa() {
        val cardType = "Visa"
        val previousTransactionsThisMonth = 0
        val initialAmount = 1_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(993, result)
    }

    @Test
    fun transactionRatesCalcVK() {
        val cardType = "Vk pay"
        val previousTransactionsThisMonth = 0
        val initialAmount = 1_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(1000, result)
    }

    @Test
    fun transactionRatesCalcMastercard() {
        val cardType = "Mastercard"
        val previousTransactionsThisMonth = 0
        val initialAmount = 100_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(99380, result)
    }

    @Test
    fun transactionRatesCalcMastercardLimit() {
        val cardType = "Mastercard"
        val previousTransactionsThisMonth = 0
        val initialAmount = 15_000_001

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
    }

    @Test
    fun transactionRatesCalcVkLimit() {
        val cardType = "Vk pay"
        val previousTransactionsThisMonth = 0
        val initialAmount = 1_500_001

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
    }

    @Test
    fun transactionRatesCalcVisaLimit() {
        val cardType = "Visa"
        val previousTransactionsThisMonth = 0
        val initialAmount = 15_000_001

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
    }

    @Test
    fun transactionRatesCalcMastercardNoRates() {
        val cardType = "Mastercard"
        val previousTransactionsThisMonth = 0
        val initialAmount = 74_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(74000, result)
    }
}