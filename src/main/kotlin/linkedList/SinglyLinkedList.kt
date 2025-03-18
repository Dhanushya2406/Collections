package linkedList

class Node(var data: Int) {
    var next: Node? = null
}

class SinglyLinkedList {
    private var head: Node? = null

    fun insertAtBegin(data: Int){
        val newNode = Node(data)
        if (head == null){
            head = newNode
        }else{
            newNode.next = head
            head = newNode
        }
    }

    fun insertAtEnd(data: Int){
        val newNode = Node(data)

        var temp = head
        while (temp?.next != null){
            temp = temp.next
        }
        temp?.next = newNode

    }

    fun insertAtPosition(position: Int, data: Int){
        val newNode = Node(data)
        if (position == 0){
            newNode.next = head
            head = newNode
            return
        }

        var temp = head
        var index = 0

        while (temp != null && index < position - 1){
            temp = temp.next
            index++
        }
        if (temp == null){
            println("Position out of bounds!")
            return
        }
        newNode.next = temp.next
        temp.next = newNode
    }

    fun display(){
        var temp = head
        while (temp != null){
            print("${temp.data} -> ")
            temp = temp.next
        }
        println("null")
    }

    fun deleteAtBegin(){
        if (head == null){
            println("List is empty Nothing to delete!")
            return
        }
        head = head?.next

    }

    fun deleteAtEnd(){
        var temp = head
        var prev: Node? = null

        while (temp?.next != null){
            prev = temp
            temp = temp.next
        }
        prev?.next = temp?.next


    }
    fun deleteAtPosition(position: Int){
        var temp = head
        var prev: Node? = null
        var index = 0
        while (temp!= null && index <= position -1 ){
            prev = temp
            temp = temp.next
            index++
        }
        prev?.next = temp?.next
    }

    fun countNoOfNodes(){
        var count = 0
        var temp = head
        while (temp != null){
            temp = temp.next
            count++
        }
        println("Number of Nodes: $count")
    }

    /*fun reversal(){
        var prev: Node? = null
        var current: Node? = head
        var next: Node? = head?.next

        while(current != null){
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
    }*/

}

fun main(){

    val list = SinglyLinkedList()

    list.insertAtBegin(5)
    list.insertAtBegin(8)
    list.insertAtBegin(9)
    list.display()
    list.insertAtPosition(2,10)
    list.display()

    list.deleteAtPosition(1)
    list.display()
    println("After adding these operations")
    list.insertAtEnd(1)
    list.display()
    list.deleteAtBegin()
    list.display()
    list.deleteAtEnd()
    list.display()
    list.insertAtBegin(2)
    list.display()
    list.insertAtEnd(2)
    list.display()
    list.countNoOfNodes()
//    list.reversal()
    list.display()

}