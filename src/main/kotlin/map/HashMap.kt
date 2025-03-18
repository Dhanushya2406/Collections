package map

class EntryNode<K, V>(val key: K, var value: V, var next: EntryNode<K, V>? = null)

class HashMap<K, V>(private val capacity: Int = 10){
    private var size = 0
    private var buckets = Array<EntryNode<K, V>?>(capacity){
        null
    }

    private fun hashFunction(key: K): Int {
        val index = key.hashCode()% capacity
        return index
    }

    fun put(key: K, value: V){
        val index = hashFunction(key)
        var current = buckets[index]

        // checking key, it is empty, insert a new entry
        if (current == null){
            buckets[index] = EntryNode(key,value)
            size++
            return
        }
        // check if the key is existed, update value
        while (current!= null){
            if (current.key == key){
                current.value = value
                return
            }
            if (current.next == null) break  // check current.next is null, exit the loop

            current = current.next // need to check, if the key is not matched then, move to the next node.
        }

        current?.next = EntryNode(key,value)
        size++
    }

    fun get(key: K): V?{
        val index = hashFunction(key)
        var current = buckets[index]
        while(current != null) {
            if (current.key == key){
                return current.value
            }
            current = current.next
        }
        return null
    }

    fun remove(key: K): Boolean{
        val index = hashFunction(key)
        var current = buckets[index]
        var prev: EntryNode<K,V>? = null

        while (current != null){
            if (current.key == key){
                if (prev == null){
                    buckets[index] = current.next
                }else{
                    prev.next = current.next
                }
                size--
                return true
            }
            prev = current
            current = current.next
        }
        return false
    }

    fun display(){
        for (i in buckets.indices){
            var current = buckets[i]
            while (current!= null){
                print("${current.key} -> ${current.value},")
                current = current.next
            }
        }
        println()
    }
}

fun main(){
    val list = HashMap<String,Int>()
    list.put("One", 1)
    list.put("Two", 2)
    list.put("Three", 3)
    list.put("Four", 4)
    list.put("Five", 5)
    list.put("Six", 6)
    list.put("Seven", 7)
    list.put("Eight", 8)
    list.display()
    println("Display: ${list.get("One")}")
    list.remove("Three")
    list.display()



}