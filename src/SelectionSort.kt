fun selectionSort(list: List<Int>): List<Int> {
    val originalList = list.toMutableList()
    val sorted = mutableListOf<Int>()
    while (originalList.size > 0) {
        val indexOfSmallest = findSmallestElement(originalList)
        sorted.add(originalList.removeAt(indexOfSmallest))
    }
    return sorted
}

fun selectionSortInPlace(list: List<Int>): List<Int> {
    val listToSort = list.toMutableList()
    var i = 0
    while (i < list.size) {
        var j = i + 1
        while (j < list.size) {
            if (listToSort[j] < listToSort[i]) swapPositionsOfItems(listToSort, i, j)
            j += 1
        }
        i += 1
    }
    return listToSort
}

private fun swapPositionsOfItems(list: MutableList<Int>, indexA: Int, indexB: Int) {
    val itemA = list[indexA]
    list[indexA] = list[indexB]
    list[indexB] = itemA
}

private fun findSmallestElement(list: List<Int>): Int {
    var indexOfSmallest = 0
    var smallestValue = list.first()
    list.forEachIndexed { index, number ->
        if (number < smallestValue) {
            indexOfSmallest = index
            smallestValue = number
        }
    }
    return indexOfSmallest
}