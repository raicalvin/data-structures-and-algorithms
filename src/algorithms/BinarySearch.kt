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