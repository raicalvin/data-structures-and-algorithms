package algorithms

// Searches the given list for the item and returns an index of its found position or null otherwise
fun linearSearch(list: List<Int>, item: Int): Int? {
    var foundIndex: Int? = null
    if (list.isEmpty()) return null
    var i = 0
    while (foundIndex == null && i < list.size) {
        if (list[i] == item) foundIndex = i
        i += 1
    }
    return foundIndex
}