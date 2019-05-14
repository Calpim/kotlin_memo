import java.util.*
import java.text.*


const val DATE_FORMAT_YYYYMMDD_SPLIT_SLASH: String = """yyyy/MM/dd"""
const val DATE_FORMAT_YYYYMMDD: String = "yyyyMMdd"
const val DATE_FORMAT_YYYYMMDD_HHDDSS_SSS_SPLIT_SLASH: String = """yyyy/MM/dd HH:mm:ss.SSS"""
const val DATE_FORMAT_YYYYMMDD_HHDDSS_SSS: String = "yyyyMMddHHddssSSS"
const val DATE_FORMAT_YYYYMMDD_HHDDSS_SPLIT_SLASH: String = """yyyy/MM/dd HH:mm:ss"""
const val DATE_FORMAT_YYYYMMDD_HHDDSS: String = "yyyyMMddhhmmss"
const val TIME_FORMAT_HHDDSS_SPLIT: String = """HH:mm:ss"""

const val MILLSECONDS_BUNSHI_DATE:Long = 1000 * 60 * 60 * 24
const val MILLSECONDS_BUNSHI_HOUR:Long = 1000 * 60 * 60
const val MILLSECONDS_BUNSHI_MINUTE:Long = 1000 * 60

fun main(args: Array<String>) {

    val diffDate = DiffDateCalc("2019/05/14 09:00:00","2019/05/14 17:30:00",DATE_FORMAT_YYYYMMDD_HHDDSS_SPLIT_SLASH)
    println("日付：${diffDate.diffDateToDate()}")
    println("時間：${diffDate.diffDateToHour()}")
    println("分：${diffDate.diffDateToMinute()}")
    
    println("")
    
    val diffTime = DiffDateCalc("12:30:00","13:00:00",TIME_FORMAT_HHDDSS_SPLIT)
    println("時間：${diffTime.diffDateToHour()}")
    
    println("${diffDate.diffDateMinusTime(diffTime.diffDateToLong!!)}")
    
    var str: String? = "null or String ?"
    ensureNotNull(str) { obj ->
        println(obj)
    }
    
}

inline fun <T> ensureNotNull(p1: T?, f: (p1: T) -> Unit) {
    if (p1 != null) f(p1)
}

class DiffDateCalc constructor(from: String ,to: String ,regex: String) {
    val sdf = SimpleDateFormat(regex)
    val fromDateToLong: Long? = sdf.parse(from)?.getTime()
    val toDateToDate: Long? = sdf.parse(to)?.getTime()
    val diffDateToLong: Long?
    
    init {
        if(fromDateToLong != null && toDateToDate != null) {
            diffDateToLong = toDateToDate - fromDateToLong
        } else {
            diffDateToLong = 0L
        }
    }

    fun diffDateToDate():Long {
        return diffDateToLong!! / MILLSECONDS_BUNSHI_DATE
    }
    
    fun diffDateToHour():String {
        val hour = diffDateToLong!! / MILLSECONDS_BUNSHI_HOUR
        val minute = (diffDateToLong!! % MILLSECONDS_BUNSHI_HOUR) / MILLSECONDS_BUNSHI_MINUTE
        return "${hour.toString()}:${minute.toString()}"
    }
    
    fun diffDateToMinute(): Long {
        return diffDateToLong!! / MILLSECONDS_BUNSHI_MINUTE
    }
    
    fun diffDateMinusTime(time: Long): String? {
        if(diffDateToLong == null || diffDateToLong < 1L) return null
        
        val diffTime = diffDateToLong - time
        val hour = diffTime!! / MILLSECONDS_BUNSHI_HOUR
        val minute = (diffTime!! % MILLSECONDS_BUNSHI_HOUR) / MILLSECONDS_BUNSHI_MINUTE
        return "${hour.toString()}:${minute.toString()}"
    }
}
