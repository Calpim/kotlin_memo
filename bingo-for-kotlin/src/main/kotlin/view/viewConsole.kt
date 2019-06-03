// VIEW
/** コンソールにpannelを表示する */
fun viewPannel(pannel_BINGO: Array<Array<Int?>>) {
    // タイトルを表示
    println(TITLE)
    pannel_BINGO.forEach() {
        print(SINGLE_SPACE)
        it.forEachIndexed { index ,num ->
            if (num == PANNEL_CENTER) {
                print("$CENTER")
            } else if(index == 4) {
                print("${convertNumToString(num)}")
            } else {
                print("${convertNumToString(num)}${RIGHT_SPACE}")
            }
        }
        // 改行
        println()
    }
}

