/** ランダムで引数のリストの中身をひとつ取り出す */
fun randamizeValue(array: List<Int>): Int {
    // java.util.Randomを初期化
    val r = java.util.Random()
    val randomInt = r.nextInt(ARRAY_LENGTH)
    
    // 引数のリストからランダムで値を取り出す
    return array.get(randomInt)
}

/** 引数の値を文字列で返却する このとき1桁の数字は先頭に0をつけて返却する */
fun convertNumToString(num: Int?): String {
    when {
        num == 0 -> {
            return ZERO_STRING
        }
        num == 1 -> {
            return ONE_STRING
        }
        num == 2 -> {
            return TWO_STRING
        }
        num == 3 -> {
            return THREE_STRING
        }
        num == 4 -> {
            return FOUR_STRING
        }
        num == 5 -> {
            return FIVE_STRING
        }
        num == 6 -> {
            return SIX_STRING
        }
        num == 7 -> {
            return SEVEN_STRING
        }
        num == 8 -> {
            return EIGHT_STRING
        }
        num == 9 -> {
            return NINE_STRING
        }
        num == null -> {
            return "00"
        }
        else -> {
            return num.toString()
        }
    }
}
