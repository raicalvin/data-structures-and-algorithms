// Finds the largest square plot of land for a given farm land of length and height
fun splitFarmland(length: Int, height: Int): Int {
    if (length > height) {
        val remainder = length.mod(height)
        if (remainder == 0) return height
        return splitFarmland(height, remainder)
    } else {
        val remainder = height.mod(length)
        if (remainder == 0) return length
        return splitFarmland(length, remainder)
    }
}

// Recursively sums the items in the list
fun sumRecursive(list: List<Int>): Int {
    if (list.isEmpty()) return 0
    if (list.size == 1) return list.first()
    return list.first() + sumRecursive(list.subList(1, list.size))
}

// Recursively counts the number of items in the list
fun countRecursive(total: Int, list: List<Int>): Int {
    if (list.isEmpty()) return total

    return countRecursive(total + 1, list.subList(1, list.size))
}

// Recursively finds the largest number in the list
fun findMaximum(largestFound: Int = -1, list: List<Int>): Int {
    if (list.isEmpty()) return largestFound

    val largest = if (largestFound > list.first()) largestFound else list.first()
    return findMaximum(largest, list.subList(1, list.size))
}