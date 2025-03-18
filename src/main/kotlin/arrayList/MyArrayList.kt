package arrayList

class MyArrayList {
    private var size = 0
    private var capacity = 10
    private var array = Array(capacity){-1}

    fun insert(value: Int){
        // if the size and capacity is equal,then resize the array automatically
        if (size == capacity){
            resize()
        }
        array[size++] = value
    }

    fun insertAtPosition(index: Int, value: Int){
        // index is bigger than size, it will throw invalid index message
        if (index > size){
            throw IndexOutOfBoundsException("Invalid Index")
        }

        // if the size and capacity is equal,then resize the array automatically
        if (size == capacity){
            resize()
        }

        // insert value - middle or first position change
        for (i in size downTo index+1){
            array[i] = array[i-1]
        }
        array[index] = value
        size++
    }

    fun display(){
        for (i in 0 until size){
            print("${array[i]} -> ")
        }
        println()
    }

    fun displayAtPosition(index: Int): Int{
        if (index > size){
            throw IndexOutOfBoundsException("Invalid Index")
        }
        return array[index]
    }

    fun deleteAtPosition(index: Int){
        if (index > size){
            throw IndexOutOfBoundsException("Invalid Index")
        }

        for (i in index until size - 1){
            array[i] = array[i+1]
        }
        array[size - 1] = -1
        size--
    }

    fun updateAtPosition(index: Int, value: Int){
        if (index > size){
            throw IndexOutOfBoundsException("Invalid Index")
        }
        array[index] = value
    }


    private fun resize(){
        capacity *= 2
        val newNode = Array(capacity){-1}
        for (i in 0 until size){
            newNode[i] = array[i]
        }
        array = newNode
    }

}

fun main(){

    val list = MyArrayList()
    list.insert(10)
    list.insert(20)
    list.insert(30)
    list.insert(40)
    list.display()
    list.insertAtPosition(2,25)
    list.display()
    println("display at position:${list.displayAtPosition(1)}")
    list.deleteAtPosition(3)
    list.display()
    list.updateAtPosition(2,30)
    list.display()
}