package app

data class Customer(
    var name :String = "Nazwa",
    var code :String = "Kod",
    var flag :Boolean = false,
    var intValue : Int = 1,
    var floatValue : Double = 1.2)

open class StringRes(val text : String?, val id : Int?) {
    constructor(text : String) : this(text, null)
    constructor(id : Int) : this(null, id)
}

open class ModelField(val name : String, caption : StringRes? = null) {
    val caption : StringRes = caption ?: StringRes(capitalisedFirstLetter(name))
}

class ModelIntField(name : String,  caption : StringRes? = null) : ModelField(name, caption) {
    var min : Int? = null
    var max : Int? = null
    var default : Int? = null

    fun withMin()
}
class ModelLongField(name : String,  caption : StringRes? = null) : ModelField(name, caption) {
    var min :Long? = null
    var max : Long? = null
    var default : Long? = null
}


fun intField(name : String, caption : StringRes? = null) = ModelIntField(name, caption)
fun intField(name : String, caption : String) = intField(name, StringRes(caption))



open class ModelDefinition {

}

private fun capitalisedFirstLetter(input : String) : String {
    if (input.isBlank())
        return input
    return input.substring(0, 1).uppercase() + input.substring(1)
}


class CustomerModelDefinition : ModelDefinition() {
    val name = intField("name", "Name").apply {
        min = 1
    }

}



