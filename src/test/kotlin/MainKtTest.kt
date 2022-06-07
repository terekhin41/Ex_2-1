import junit.framework.TestCase.assertEquals
import org.junit.Test



class MainKtTest {

    @Test
    fun feeCalculation_MasterCard_lowTransfers() {
        val amount : UInt = 1000_00u
        val paymentSystem : PaymentSystem = PaymentSystem.MASTERCARD
        val transfersPerMonth : UInt = 10000_00u

        val result = feeCalculation(amount, paymentSystem, transfersPerMonth)

        assertEquals("Ошибочное значение", result)
    }

    @Test
    fun feeCalculation_MasterCard_highTransfers() {
        val amount : UInt = 1000_00u
        val paymentSystem : PaymentSystem = PaymentSystem.MASTERCARD
        val transfersPerMonth : UInt = 90000_00u

        val result = feeCalculation(amount, paymentSystem, transfersPerMonth)

        assertEquals(26_00u, result)
    }

    @Test
    fun feeCalculation_MasterCard_partialPrivilege() {
        val amount : UInt = 15000_00u
        val paymentSystem : PaymentSystem = PaymentSystem.MASTERCARD
        val transfersPerMonth : UInt = 70000_00u

        val result = feeCalculation(amount, paymentSystem, transfersPerMonth)

        assertEquals(80_00u, result)
    }

    @Test
    fun feeCalculation_Visa() {
        val amount : UInt = 1000_00u
        val paymentSystem : PaymentSystem = PaymentSystem.VISA
        val transfersPerMonth : UInt = 10000_00u

        val result = feeCalculation(amount, paymentSystem, transfersPerMonth)

        assertEquals(35_00u, result)
    }

    @Test
    fun feeCalculation_VkPay() {
        val amount : UInt = 1000_00u
        val paymentSystem : PaymentSystem = PaymentSystem.VK_PAY
        val transfersPerMonth : UInt = 10000_00u

        val result = feeCalculation(amount, paymentSystem, transfersPerMonth)

        assertEquals(0u, result)
    }
}