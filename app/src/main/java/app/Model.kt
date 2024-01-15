package app

import common.shared.modeldefinition.ModelDefinition
import common.shared.modeldefinition.booleanField
import common.shared.modeldefinition.doubleField
import common.shared.modeldefinition.intField
import common.shared.modeldefinition.stringField

data class Customer(
    var name: String = "Kontrahent pospolity111",
    var code: String = "0123",
    var flag: Boolean = false,
    var intValue: Int = 12,
    var floatValue: Double = 1.22)

val customerDefinition = object : ModelDefinition()  {
    val name = stringField("name", size = 50)
    val code = stringField("code", size = 10)
    val flag = booleanField("flag", default = true)
    val intValue = intField("intValue")
    val floatValue = doubleField("floatValue")
}





