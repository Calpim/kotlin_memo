val RIGHT_MOVE    = Pair(1 ,0)
val DOWN_MOVE     = Pair(0 ,1)
val DIAGOL_MOVE   = Pair(1, 1)


// BINGOカードのパネル情報を保存しておくEntityクラス
data class PannelArray(val column: Int ,val row: Int) {
    val pannelArray: Array<Array<Int?>> = Array(column, {arrayOfNulls<Int?>(row)})
    // Pair( row  col)
    var checkOnceSet = mutableSetOf<Pair<Int ,Int>>()

    /**  */
    fun checkForHit(target: Int): Boolean {
        val row = checkColumn(target)
        row?.let() {
            for(j in 0..WIDTH-1) {
                // 2次元配列の中からターゲットと一致する値がある場合 : true
                if(this.pannelArray[j][row] == target) {
                    this.checkOnceSet.add(Pair(row ,j))
                    return true
                }
            }
        }
        // 一致するあたいがない場合 : false
        return false
    }
    
    fun updatePannel() {
        this.checkOnceSet.forEach() {
            val (row ,col) = it
            this.pannelArray[col][row] = 0
        }
    }

    fun getPannelValue(col: Int ,row: Int): Int? {
        return this.pannelArray[col][row]
    }
    fun setPannelValue(col: Int ,row: Int ,value: Int) {
        this.pannelArray[col][row] = value
    }
}

fun checkColumn(target: Int): Int? {
    when {
        target == 0 -> {
            return null
        }
        target < 16 -> {
            return 0
        }
        target < 31 -> {
            return 1
        }
        target < 46 -> {
            return 2
        }
        target < 61 -> {
            return 3
        }
        target < 76 -> {
            return 4
        }
        else -> {
            return null
        }
    }
}

fun checkBINGO(pannel: PannelArray): Boolean {
    if(pannel.checkOnceSet.size >= 5) {
        if(checkSet(pannel.checkOnceSet)) return true
    }
    return false
}

fun checkSet(array: Set<Pair<Int ,Int>>): Boolean {
    BINGO_VARIATION.forEach() {
        if(array.containsAll(it)) return true
    }
    return false
}

val BINGO_FOR_COLUMN_ONE    = arrayOf(Pair(0 ,0),Pair(0 ,1),Pair(0 ,2),Pair(0 ,3),Pair(0 ,4)).toList()
val BINGO_FOR_COLUMN_TWO    = arrayOf(Pair(1 ,0),Pair(1 ,1),Pair(1 ,2),Pair(1 ,3),Pair(1 ,4)).toList()
val BINGO_FOR_COLUMN_THREE  = arrayOf(Pair(2 ,0),Pair(2 ,1),Pair(2 ,2),Pair(2 ,3),Pair(2 ,4)).toList()
val BINGO_FOR_COLUMN_FOUR   = arrayOf(Pair(3 ,0),Pair(3 ,1),Pair(3 ,2),Pair(3 ,3),Pair(3 ,4)).toList()
val BINGO_FOR_COLUMN_FIVE   = arrayOf(Pair(4 ,0),Pair(4 ,1),Pair(4 ,2),Pair(4 ,3),Pair(4 ,4)).toList()

val BINGO_FOR_ROW_ONE       = arrayOf(Pair(0 ,0),Pair(1 ,0),Pair(2 ,0),Pair(3 ,0),Pair(4 ,0)).toList()
val BINGO_FOR_ROW_TWO       = arrayOf(Pair(0 ,1),Pair(1 ,1),Pair(2 ,1),Pair(3 ,1),Pair(4 ,1)).toList()
val BINGO_FOR_ROW_THREE     = arrayOf(Pair(0 ,2),Pair(1 ,2),Pair(2 ,2),Pair(3 ,2),Pair(4 ,2)).toList()
val BINGO_FOR_ROW_FOUR      = arrayOf(Pair(0 ,3),Pair(1 ,3),Pair(2 ,3),Pair(3 ,3),Pair(4 ,3)).toList()
val BINGO_FOR_ROW_FIVE      = arrayOf(Pair(0 ,4),Pair(1 ,4),Pair(2 ,4),Pair(3 ,4),Pair(4 ,4)).toList()

val DIAGOL_LOWER_RIGHT      = arrayOf(Pair(0 ,0),Pair(1 ,1),Pair(2 ,2),Pair(3 ,3),Pair(4 ,4)).toList()
val DIAGOL_UPPER_RIGHT      = arrayOf(Pair(0 ,4),Pair(1 ,3),Pair(2 ,2),Pair(3 ,1),Pair(4 ,0)).toList()

val BINGO_VARIATION = arrayOf(
        BINGO_FOR_COLUMN_ONE    ,
        BINGO_FOR_COLUMN_TWO    ,
        BINGO_FOR_COLUMN_THREE  ,
        BINGO_FOR_COLUMN_FOUR   ,
        BINGO_FOR_COLUMN_FIVE   ,

        BINGO_FOR_ROW_ONE       ,
        BINGO_FOR_ROW_TWO       ,
        BINGO_FOR_ROW_THREE     ,
        BINGO_FOR_ROW_FOUR      ,
        BINGO_FOR_ROW_FIVE      ,

        DIAGOL_LOWER_RIGHT      ,
        DIAGOL_UPPER_RIGHT
)

