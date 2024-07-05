// Sorts a list of numbers and returns them in ascending order
fun insertionSort(list: List<Int>): List<Int> {
    val listToSort = list.toMutableList()
    if (listToSort.isEmpty() || listToSort.size == 1) return listToSort

    for (j in 1..<listToSort.size) {
        val current = listToSort[j]
        var i = j - 1
        while (i >= 0 && listToSort[i] > current) {
            listToSort[i+1] = listToSort[i]
            i -= 1
        }
        listToSort[i+1] = current
    }

    return listToSort
}

// Sorts a list of numbers and returns them in descending order
fun insertionSortDescending(list: List<Int>): List<Int> {
    val listToSort = list.toMutableList()
    if (listToSort.isEmpty() || listToSort.size == 1) return listToSort

    for (j in 1..<listToSort.size) {
        val current = listToSort[j]
        var i = j - 1
        while (i >= 0 && listToSort[i] < current) {
            listToSort[i+1] = listToSort[i]
            i -= 1
        }
        listToSort[i+1] = current
    }
    return listToSort
}