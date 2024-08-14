package algorithms

fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) return list

    if (list.size == 2) {
        return if (list.first() > list.last()) listOf(list.last(), list.first()) else return list
    }

    val pivot = list.first()
    val smaller = mutableListOf<Int>()
    val larger = mutableListOf<Int>()

    list.drop(1).forEach { if (it <= pivot) smaller.add(it) else larger.add(it) }

    return quickSort(smaller) + pivot + quickSort(larger)
}