package stack

class Stack(size: Int){
    private val items = Array<Int>(size,{index ->
        -1
    })
    private var index = 0

    fun push(value: Int){
        if (index<items.size){
            items.set(index++,value)
            println("Pushed: $value")
        }else{
            println("Stack over flow")
        }
    }

    fun pop(): Int{
        val result = items[--index]
        return result
    }

    fun peek(): Int{
        val x = items.get(index - 1)
        return x
    }

}

fun main(){

    val obj = Stack(10)
    obj.push(10)
    obj.push(20)
    obj.push(30)
    obj.push(40)
    obj.push(50)
    println("After Push...")
    println("Popped:"+obj.pop()) // index = 5 irukum next --index (4) result  item[4]= 50 next index 4
    println("Popped:"+obj.pop())  // index = 4 irukum next --index (3) result  item[3]= 40 next index 3
    println(obj.peek()) // index = 3 current index venuna -1 pananu so, index-1 = item[2]
    println(obj.peek()) //same result -> index = 3 current index venuna -1 pananu so, index-1 = item[2]

}