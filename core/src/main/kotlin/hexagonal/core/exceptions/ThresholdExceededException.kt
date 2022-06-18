package hexagonal.core.exceptions

import hexagonal.core.domain.Money
import java.lang.RuntimeException

class ThresholdExceededException(override val message: String)
    : RuntimeException(message) {
    constructor(threshold: Money, actual: Money) :
        this("Maximum threshold for transferring money exceeded: tried to transfer ${threshold.amount} but threshold is ${actual.amount}!")
    

}