package algorithms

fun binarySearch(list: List<Int>, item: Int): Int? {
    var lowIndex = 0
    var highIndex = list.size - 1

    while (lowIndex <= highIndex) {
        val midIndex = (lowIndex + highIndex) / 2
        val guess = list[midIndex]

        when {
            guess < item -> lowIndex = midIndex + 1
            guess > item -> highIndex = midIndex - 1
            else -> return midIndex
        }
    }

    return null
}

fun binarySearchDivideAndConquer(list: List<Int>, target: Int, leftIndex: Int, rightIndex: Int): Int? {
    if (leftIndex > rightIndex) return null

    val midIndex = (leftIndex + rightIndex) / 2
    val element = list[midIndex]

    return when {
        element == target -> midIndex
        element > target -> binarySearchDivideAndConquer(list, target, leftIndex, midIndex - 1)
        else -> binarySearchDivideAndConquer(list, target, midIndex + 1, rightIndex)
    }
}