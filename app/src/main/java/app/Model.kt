package app

import common.shared.modeldefinition.ModelDefinition
import common.shared.modeldefinition.intField

data class Customer(
    var name: String = "Kontrahent pospolity111",
    var code: String = "0123",
    var flag: Boolean = false,
    var intValue: Int = 12,
    var floatValue: Double = 1.22)

val customerDefinition = object : ModelDefinition()  {
    val intValue = intField("intValue")
}





