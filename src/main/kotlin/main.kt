import PaymentSystem.*
import kotlin.math.ceil
import kotlin.math.max

fun main() {    

}

fun feeCalculation(
    amount: UInt,
    paymentSystem: PaymentSystem = VK_PAY,
    transfersPerMonth: UInt = 0u
): UInt {
    return when (paymentSystem) {
        MASTERCARD, MAESTRO -> {
            if (transfersPerMonth >= 75000_00u)
                20_00u + ceil(0.006 * amount.toDouble()).toUInt()
            else if (transfersPerMonth + amount > 75000_00u)
                20_00u + ceil(0.006 * (amount + transfersPerMonth - 75000_00u).toDouble()).toUInt()
            else 0u
        }
        VISA, MIR -> max(ceil(0.0075 * amount.toDouble()).toUInt(), 35_00u)
        VK_PAY -> 0U
    }
}