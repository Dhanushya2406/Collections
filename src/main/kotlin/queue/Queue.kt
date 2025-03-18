package kt.dsa.queue

class Queue(size: Int) {
    private val items = Array(size){_ ->
        -1
    }
    private var index = -1

    fun enqueue(value: Int){
        if (index == items.size)
            println("Queue is full")

        items[++index] = value
        println("Enqueue:$value")
    }

    fun deQueue(): Int?{
        return if (index == -1) {
            println("Queue is Empty")
            null
        }else{
            val value = items[0]
            shiftItems()
            --index
            value
        }
    }

    private fun shiftItems(){
        for (i in 1 until items.size){
            val temp = items[i]
            items[i] = -1
            items[i-1] = temp
        }
    }

    // First Dequeue methods..
    /*fun deQueue(): Int?{
        return if (start == -1 || start>index) {
            println("Queue is Empty")
            null
        }else{
            val value = items[start++]
            println("Dequeue:$value")
            value
        }
    }*/
}

fun main(){

    val obj = Queue(5)
    obj.enqueue(10)
    obj.enqueue(20)
    println("Before Dequeue..")
    println("Dequeue:"+obj.deQueue())
    obj.enqueue(30)
    println("Dequeue:"+obj.deQueue())
    println("Dequeue:"+obj.deQueue())
    println("Dequeue:"+obj.deQueue())
    obj.enqueue(40)
    obj.enqueue(50)
    println("Dequeue:"+obj.deQueue())
    obj.enqueue(60)
    println("Dequeue:"+obj.deQueue())
    println("Dequeue:"+obj.deQueue())
    println("Dequeue:"+obj.deQueue())


}