package common.shared.extensions

class StringLabel(val text: String?, val id: Int?) {
    constructor(text: String) : this(text, null)
    constructor(id: Int) : this(null, id)
}


fun String.capitalisedFirstLetter() : String {
    if (isBlank())
        return this
    return substring(0, 1).uppercase() + substring(1)
}

