package algorithms

val graph = mutableMapOf<String, Map<String, Int>>()
val costs = mutableMapOf<String, Int>()
val parents = mutableMapOf<String, String>()
val processedNodes = mutableListOf<String>()

fun dijkstrasAlgorithm() {
    initializeGraphs()
    var node = lowestCostNode()

    while (node != null) {
        val nodeCost = costs[node] ?: Int.MAX_VALUE
        val neighbors = graph[node]
        neighbors?.forEach { neighbor ->
            val newNeighborCost = nodeCost + neighbor.value
            if (newNeighborCost < (costs[neighbor.key] ?: Int.MAX_VALUE)) {
                parents[neighbor.key] = node ?: ""
                costs[neighbor.key] = newNeighborCost
            }
        }
        processedNodes.add(node)
        node = lowestCostNode()
    }

    analyzeRoute()
}

private fun initializeGraphs() {
    initializeGraph()
    initializeCosts()
    initializeParents()
}

private fun initializeGraph() {
    graph["S"] = mutableMapOf("A" to 5, "B" to 2)
    graph["A"] = mutableMapOf("C" to 4, "D" to 2)
    graph["B"] = mutableMapOf("D" to 7, "A" to 8)
    graph["C"] = mutableMapOf("F" to 3, "D" to 6)
    graph["D"] = mutableMapOf("F" to 1)
}

private fun initializeCosts() {
    costs["A"] = 5
    costs["B"] = 2
    costs["C"] = Int.MAX_VALUE
    costs["D"] = Int.MAX_VALUE
    costs["F"] = Int.MAX_VALUE
}

private fun initializeParents() {
    parents["A"] = "S"
    parents["B"] = "S"
    parents["C"] = ""
    parents["D"] = ""
    parents["F"] = ""
}

private fun analyzeRoute() {
    var node = "F"
    var result = "F -> "
    while (node != "S") {
        val parent = parents[node]
        result += if (parent == "S") "S" else "$parent -> "
        node = parent ?: ""
    }
    println("The fastest route is: $result")
}

private fun lowestCostNode(): String? {
    var node: String? = null
    var cost = Int.MAX_VALUE

    costs.forEach {
        if (processedNodes.contains(it.key).not()) {
            if (it.value < cost) {
                node = it.key
                cost = it.value
            }
        }
    }

    return node
}