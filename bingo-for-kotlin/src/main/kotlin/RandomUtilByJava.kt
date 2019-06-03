import java.util.*

var numberOfHitForSet = mutableSetOf<Int>()

fun numberOfHit(): Int {
    do {
        val value = getRandomValue()
        if(numberOfHitForSet.add(value)) return value
    }while(true)
    
    return 0
}

fun getRandomValue(): Int {
    val rand = Random()
    val randomInt = rand.nextInt(75 + 1)
    
    return randomInt
}
