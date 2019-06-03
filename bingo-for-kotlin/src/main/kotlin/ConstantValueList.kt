/**
 *
 * 定数クラス
 * 
 */
const val PANNEL_CENTER = 0
const val PANNEL_CENTER_TO_STRING = "*"
const val SINGLE_SPACE = " "
const val HIEGHT_STICK = "|"
const val THREE_SPACE = "  "

const val RIGHT_SPACE = "$HIEGHT_STICK$THREE_SPACE"
const val CENTER =  " ${PANNEL_CENTER_TO_STRING}${RIGHT_SPACE}"
const val TITLE = "  B${RIGHT_SPACE} I${RIGHT_SPACE} N${RIGHT_SPACE} G${RIGHT_SPACE} O"

const val WIDTH = 5
const val HEIGHT = 5
const val WIDTH_CENTER = WIDTH / 2
const val HEIGHT_CENTER = HEIGHT / 2

const val ARRAY_LENGTH = 15

/** 1桁の数字の文字列 */
const val ZERO_STRING   = "00"
const val ONE_STRING    = "01"
const val TWO_STRING    = "02"
const val THREE_STRING  = "03"
const val FOUR_STRING   = "04"
const val FIVE_STRING   = "05"
const val SIX_STRING    = "06"
const val SEVEN_STRING  = "07"
const val EIGHT_STRING  = "08"
const val NINE_STRING   = "09"

// 1~15 16~30 31~45 46~60 61~75
/** リストに15個の値を埋め込む */
val ARRAY_B: List<Int> = (1..15).toList()
val ARRAY_I: List<Int> = (16..30).toList()
val ARRAY_N: List<Int> = (31..45).toList()
val ARRAY_G: List<Int> = (46..60).toList()
val ARRAY_O: List<Int> = (61..75).toList()

