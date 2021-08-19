import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
    fun transactionRatesCalcMir() {
        val cardType = "Мир"
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
    fun transactionRatesCalcMirLimitAnother() {
        val cardType = "Мир"
        val previousTransactionsThisMonth = 60_000_000
        val initialAmount = 1_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
    }

    @Test
    fun transactionRatesCalcVisaLimitAnother() {
        val cardType = "Visa"
        val previousTransactionsThisMonth = 60_000_000
        val initialAmount = 1_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
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
    fun transactionRatesCalcVkLimitAnother() {
        val cardType = "Vk pay"
        val previousTransactionsThisMonth = 4_000_000
        val initialAmount = 1_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
    }

    @Test
    fun transactionRatesCalcAnotherCard() {
        val cardType = "Test"
        val previousTransactionsThisMonth = 4_000_000
        val initialAmount = 1_000

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(0, result)
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
    fun transactionRatesCalcMaestro() {
        val cardType = "Maestro"
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
    fun transactionRatesCalcMastercardLimitAnother() {
        val cardType = "Mastercard"
        val previousTransactionsThisMonth = 60_000_000
        val initialAmount = 15_000_001

        val result = transactionRatesCalc(
            cardType = cardType,
            previousTransactionsThisMonth = previousTransactionsThisMonth,
            initialAmount = initialAmount
        )

        assertEquals(-1, result)
    }

    @Test
    fun transactionRatesCalcMaestroLimit() {
        val cardType = "Maestro"
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
    fun transactionRatesCalcMaestroLimitAnother() {
        val cardType = "Maestro"
        val previousTransactionsThisMonth = 60_000_000
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

        assertEquals(740000, result)
    }
}