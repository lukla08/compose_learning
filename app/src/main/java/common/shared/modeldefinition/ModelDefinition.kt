package common.shared.modeldefinition

import common.shared.extensions.StringLabel
import common.shared.extensions.capitalisedFirstLetter

open class ModelField<T>(
    val name: String, caption : StringLabel? = null,
    val default : T? = null) {
    val caption: StringLabel = caption ?: StringLabel(name.capitalisedFirstLetter())
}

open class ModelFieldWithMinMax<T>(
    name : String, caption : StringLabel?= null,
    default :T? = null, val min: T? = null, val max: T? = null) : ModelField<T>(name, caption, default)

class DoubleField(
    name : String, caption : StringLabel?= null,
    default : Double? = null, min: Double? = null, max: Double? = null,
    val scale : Int , val precision : Int) :  ModelFieldWithMinMax<Double>(name, caption, default, min, max)

class ModelStringField(name: String, caption: StringLabel? = null,
                  default: String? = null, size : Int,
                  val isMemo : Boolean = false) : ModelField<String>(name, caption, default)

fun intField(name: String, caption: StringLabel? = null, default: Int? = null, min: Int? = null, max: Int? = null)
        = ModelFieldWithMinMax(name, caption, default, min, max)
fun intField(name:  String, caption: String, default: Int? = null,  min: Int? = null, max: Int? = null)
        = intField(name, StringLabel(caption), default, min, max)

fun doubleField(name: String, caption: StringLabel? = null,
                default: Double? = null, min: Double? = null, max: Double? = null,
                scale : Int = 18, precision : Int = 2)
    = DoubleField(name, caption, default, min, max, scale, precision)
fun doubleField(name: String, caption: String,
                default: Double? = null, min: Double? = null, max: Double? = null,
                scale : Int = 18, precision : Int = 2)
    = doubleField(name, StringLabel(caption), default, min, max, scale, precision)

fun stringField(name: String, caption: StringLabel? = null, default: String? = null, size : Int)
    = ModelStringField(name, caption, default, size)
fun stringField(name: String, caption: String, default: String? = null, size : Int)
    = stringField(name, StringLabel(caption), default, size)

fun memoField(name: String, caption: StringLabel? = null, default: String? = null, size : Int)
        = ModelStringField(name, caption, default, size, isMemo = true)
fun memoField(name: String, caption: String, default: String? = null, size : Int)
        = memoField(name, StringLabel(caption), default, size)

fun booleanField(name: String, caption: StringLabel? = null, default : Boolean? = null)
    = ModelField(name, caption, default)
fun booleanField(name: String, caption: String, default: Boolean? = null)
        = booleanField(name, StringLabel(caption), default)


open class ModelDefinition {
}
