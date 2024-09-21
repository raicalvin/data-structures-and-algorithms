package datastructures

// A simple queue data structure that will function FIFO
class Queue<T>() {

    private val queue = mutableListOf<T>()

    fun pop() = queue.removeFirstOrNull()

    fun push(item: T) = queue.add(item)

    fun push(items: Collection<T>) = queue.addAll(items)

    fun peek() = if (queue.isNotEmpty()) queue.first() else null

    val isNotEmpty: Boolean
        get() = this.queue.size > 0

    override fun toString(): String {
        var output = "Queue Content = "
        queue.forEach { item -> output += "$item, " }
        return output
    }
}