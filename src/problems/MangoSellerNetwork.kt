package problems

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