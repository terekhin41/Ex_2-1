import junit.framework.TestCase.assertEquals
import org.junit.Test



class MainKtTest {

    @Test
    fun feeCalculation_MasterCard() {
        val amount : UInt = 1000u
        val paymentSystem : PaymentSystem = PaymentSystem.MASTERCARD
        val transfersPerMonth : UInt = 10000u

        val result = feeCalculation(amount, paymentSystem, transfersPerMonth)

        assertEquals(0u, result)
    }
}