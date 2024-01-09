package app

import common.shared.modeldefinition.ModelDefinition
import common.shared.modeldefinition.intField

data class Customer(
    var name: String = "Kontrahent pospolity",
    var code: String = "0123",
    var flag: Boolean = false,
    var intValue: Int = 1,
    var floatValue: Double = 1.2)

val customerDefinition = object : ModelDefinition()  {
    val intValue = intField("intValue")
}





