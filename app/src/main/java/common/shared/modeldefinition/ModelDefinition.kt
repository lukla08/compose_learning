package common.shared.modeldefinition

import common.shared.extensions.StringLabel
import common.shared.extensions.capitalisedFirstLetter

open class ModelField<T>(
    val name: String, caption : StringLabel? = null,
    val default : T? = null,
    val min: T? = null, val max: T? = null) {
    val caption: StringLabel = caption ?: StringLabel(name.capitalisedFirstLetter())
}

fun intField(name: String, caption: StringLabel? = null, default: Int? = null, min: Int? = null, max: Int? = null)
        = ModelField(name, caption, default, min, max)
fun intField(name:  String, caption: String, default: Int? = null,  min: Int? = null, max: Int? = null)
        = intField(name, StringLabel(caption), default, min, max)

open class ModelDefinition {

}
