package kt.dsa.queue

class Node(var data: Int){
    var next: Node? = null
}

class QueueUsingLinkedList {

    private var front: Node? = null
    private var rear: Node? = null

    fun enqueue(data: Int){
        val newNode = Node(data)

        if (front == null){
            front = newNode
            rear = newNode
        }else{
            rear?.next = newNode
            rear = newNode
        }
    }

    fun dequeue(): Int? {
        if (front == null){
            println("Queue is empty")
            return null
        }
        val temp = front?.data
        front = front?.next
        // have a node but if we dequeue that node front will go null
        // and rear it will be there at point
        // so when front goes null and at that moment rear assigned null
        if (front == null){
            rear = null
        }
        return temp
    }

    fun display(){
        var temp = front
        while(temp != null){
            print("${temp.data} ->")
            temp = temp.next
        }
        println("null")
    }

    fun peek(): Int?{
        if (front == null){
            throw IndexOutOfBoundsException("Queue is empty")
        }
        return front?.data
    }
}

fun main(){

    val list = QueueUsingLinkedList()
    list.enqueue(10)
    list.enqueue(20)
    list.enqueue(30)
    list.enqueue(40)
    list.display()
    println("Get from front elements:${list.peek()}")
    println("Dequeue:${list.dequeue()}")
    println("Dequeue:${list.dequeue()}")
    println("Dequeue:${list.dequeue()}")
    println("Dequeue:${list.dequeue()}")
    println("Dequeue:${list.dequeue()}")
    list.enqueue(10)
    list.enqueue(20)
    list.enqueue(30)
    list.display()
    println("Get from front elements:${list.peek()}")
    println("Dequeue:${list.dequeue()}")
    println("Dequeue:${list.dequeue()}")
    list.display()
    println("Get from front elements:${list.peek()}")

}