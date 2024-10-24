package problems

// This is an approximation/greedy algorithm that will pick the least amount of radio stations
// that will cover the most amount of states

val statesNeeded = mutableSetOf("mt", "wa", "or", "id", "nv", "ut", "ca", "az")
val stations = mutableMapOf<String, Set<String>>()
val finalStations = mutableSetOf<String>()

fun radioStationProblem() {

    stations["kone"] = setOf("id", "nv", "ut")
    stations["ktwo"] = setOf("wa", "id", "mt")
    stations["kthree"] = setOf("or", "nv", "ca")
    stations["kfour"] = setOf("nv", "ut")
    stations["kfive"] = setOf("ca", "az")

    while (statesNeeded.isNotEmpty()) {
        var bestStation = "" // the station that covers the most amount of uncovered states
        var statesCovered = setOf<String>() // the states this bestStation covers that haven't been covered yet
        
        stations.forEach { (station, states) ->
            val covered = statesNeeded.intersect(states)
            if (covered.size > statesCovered.size) {
                bestStation = station
                statesCovered = covered
            }
        }

        statesNeeded.removeAll(statesCovered)
        finalStations.add(bestStation)
    }

    println("Final stations: $finalStations")

}
