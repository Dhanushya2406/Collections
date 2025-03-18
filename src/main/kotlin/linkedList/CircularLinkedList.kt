package kt.dsa.linkedList

class CircularNode(var data: Int){
    var next: CircularNode? = null
}

class CircularLinkedList {
    private var last: CircularNode? = null

    fun insertAtBegin(data: Int){
        val newNode = CircularNode(data)

        if (last == null){
            newNode.next = newNode
            last = newNode
        }else{
            newNode.next = last?.next
            last?.next = newNode
        }
    }

    fun insertAtEnd(data: Int){
        val newNode = CircularNode(data)

        if (last == null){
            newNode.next = newNode
            last = newNode
        }else{
            newNode.next = last?.next
            last?.next = newNode
            last = newNode
        }
    }

    fun insertAtPosition(position: Int, data: Int){
        val newNode = CircularNode(data)
        if (position == 0){
            insertAtBegin(data)
            return
        }

        var temp = last?.next
        var index = 0

        if (temp == null) println("List is empty")

        while (index< position - 1 ){
            temp = temp?.next
            index++
        }
        newNode.next = temp?.next
        temp?.next = newNode

        if (temp == last) last = newNode

    }

    fun display(){
        if (last == null) println("List is empty")
        var temp = last?.next
        do {
            print("${temp?.data} ->")
            temp = temp?.next
        }while (temp!= last?.next)
        println("null")
    }

    fun deleteAtBegin(){
        if (last == null) throw IndexOutOfBoundsException("Deletion attempt on empty list")

        if (last?.next == last){
            last = null
        }else{
            last?.next = last?.next?.next
        }
    }

    fun deleteAtEnd(){
        if(last == null) throw IndexOutOfBoundsException("Deletion attempt on empty list")

        if (last?.next == last){
            last = null
        }else{
            var temp = last?.next
            while(temp?.next != last){
                temp = temp?.next
            }
            temp?.next = last?.next
            last = temp

        }
    }

    fun deleteAtPosition(position: Int){
        if (last == null){
            println("List is empty")
            return
        }

        if (position == 0){
            deleteAtBegin()
            return
        }
        var temp = last?.next
        var index = 0
        var prev: CircularNode? = null

        if (temp == null){
            println("Index out of bound")
            return
        }

        while (index < position){
            prev = temp
            temp = temp?.next
            index++
        }
        prev?.next = temp?.next


        if (temp == last){
            last = prev
        }
    }

}

fun main(){

    val list = CircularLinkedList()
    list.insertAtBegin(10)
    list.insertAtEnd(20)
    list.insertAtBegin(5)
    list.display()
    list.insertAtPosition(2,15)
    list.display()
    list.deleteAtPosition(2)
    list.deleteAtBegin()
    list.deleteAtEnd()
//    list.deleteAtBegin()
    list.display()



}