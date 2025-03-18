package kt.dsa.linkedList

class DoublyNode(var data: Int){
    var next: DoublyNode? = null
    var prev: DoublyNode? = null
}

class DoublyLinkedList {
    private var head: DoublyNode? = null
    private var tail: DoublyNode? = null

    fun insertAtBegin(data: Int){
        val newNode = DoublyNode(data)
        if (head == null){
            head = newNode
            tail = newNode
        }else{
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
    }

    fun insertAtPosition(position: Int, data: Int){
        val newNode = DoublyNode(data)

        if (position == 0){
            insertAtBegin(data)
            return
        }

        var temp = head
        var index = 0
        while(index < position -1 ){
            temp = temp?.next
            if (temp == null){
                throw IndexOutOfBoundsException("Invalid position")
            }
            index++
        }
        newNode.next = temp?.next
        newNode.prev = temp
        if (temp == tail){
            tail = newNode
        }else{
            temp?.next?.prev = newNode
        }
        temp?.next = newNode
    }

    fun display(){
        if (head == null) println("List is empty")
        var temp = head
        while (temp != null){
            print("${temp.data} -> ")
            temp = temp.next
        }
        println("null")
    }

    fun displayReverse(){
        if (head == null) println("List is empty")
        var temp = tail
        while (temp != null){
            print("${temp.data} -> ")
            temp = temp.prev
        }
        println("null")
    }

    fun deleteAtBegin(){
        if (head == null){
            throw IndexOutOfBoundsException("Deletion failed: List is empty")
        }
            head = head?.next
            if (head == null) {
                tail = null
            } else {
                head?.prev = null
            }
    }

    fun deleteAtPosition(position: Int){
        if (head == null){
            throw IndexOutOfBoundsException("Deletion failed: List is empty")
        }
        if (position == 0){
            head = head?.next
            if (head == null){
                tail = null
            }else{
                head?.prev = null
            }
            return
        }

        var temp = head
        var prev: DoublyNode? = null
        var index = 0

        if (temp == null) {
            throw IndexOutOfBoundsException("Invalid position")
        }

        while(temp!= null && index < position){
            prev = temp
            temp = temp.next
            index++
        }
        prev?.next = temp?.next
        if (temp?.next == null){
            tail = prev
        }else{
            temp.next?.prev = prev
        }

    }

}

fun main(){

    val list = DoublyLinkedList()
    list.insertAtBegin(10)
    list.insertAtBegin(20)
    list.insertAtBegin(30)
    println("After inserting")
    list.display()
    println("delete at begin")
    list.deleteAtBegin()
    list.display()
    println("After Reversing display")
    list.displayReverse()
    list.insertAtPosition(2,25)
    println("insert at position")
    list.display()
    list.displayReverse()
    println("delete at begin")
    list.deleteAtBegin()
    list.display()
    println("After delete")
    list.deleteAtPosition(3)
    list.display()
    list.displayReverse()

}