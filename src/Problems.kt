import datastructures.Queue

// This is a graph algorithm to find a node within a network
fun mangoSellerGraphProblem() {
    val graph = hashMapOf<String, List<String>>()
    graph.put("Calvin", listOf("Claire", "Bob", "Alice"))
    graph.put("Claire", listOf("Jonny", "Theo"))
    graph.put("Jonny", listOf())
    graph.put("Theo", listOf())
    graph.put("Bob", listOf("Anuj", "Peggy"))
    graph.put("Anuj", listOf())
    graph.put("Peggy", listOf("Tom"))
    graph.put("Alice", listOf("Peggy"))

    val mangoSeller = searchNetworkForMangoSeller("Calvin", graph)
    print(mangoSeller)
}

// return the person who is a mango seller or null otherwise
fun searchNetworkForMangoSeller(you: String, network: HashMap<String, List<String>>): String? {
    val mangoQueue = Queue<String>()
    mangoQueue.push(you)

    val checked = mutableSetOf<String>()

    while (mangoQueue.isNotEmpty) {
        val person = mangoQueue.pop() ?: ""
        if (checked.contains(person).not()) {
            if (personIsMangoSeller(person)) {
                return person
            } else {
                checked.add(person)
                network[person]?.let { mangoQueue.push(it) }
            }
        }
    }

    return null
}

// silly way to check if the person is a mango seller
fun personIsMangoSeller(person: String): Boolean {
    if (person.isEmpty()) return false
    return person.last() == 'm'
}

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