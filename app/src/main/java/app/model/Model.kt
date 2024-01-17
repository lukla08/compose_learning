package app.model

data class Assortment(
    var id: Int = 0,
    var orderIndex: Short = 0,
    var isSpecial: Boolean = false,
    var name: String = "")

data class Producer(
    var id: Int = 0,
    var orderIndex: Short = 0,
    var isSpecial: Boolean = false,
    var name: String = "",
    var palmosUuid: Int = 0)

data class WareGroup(
    var id : Int = 0,
    var masterWareGroupId : Int = 0,
    var name: String = "",
    var palmosUuid: Int = 0)

data class WareSearchParams(
    var isCaseSensitive : Boolean = false,
    var distinquishPolishChars : Boolean = false,
    var matchesFromLeftSide : Boolean = false,
    var removeNotMatchingChars : Boolean = false
)


