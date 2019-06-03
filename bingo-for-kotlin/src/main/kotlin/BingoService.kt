// MODEL
// 2次元配列のペアを登録する ペアクラス
data class PannelPair(val index: Int ,val list: List<Int>)

/** 初期処理 */
fun initPannel(): PannelArray {
    // カラム番号と対応するリストを作成する
    val arrayBINGO = createPairForArray()
    
    // 使用するパネルの範囲を決める
    // パネルの中身を変更する処理はモデルに書く
    var pannel: PannelArray = PannelArray(HEIGHT ,WIDTH)
    
    // 複雑にするくらいなら小分けにしたほうがよかった...
    pannel = setValueForPannel(pannel ,arrayBINGO)
    
    return pannel
    
}

// SERVICE
/** pannelの横列に対応したペア配列を作成する */
fun createPairForArray(): Array<PannelPair> {
    // 各縦列のペアーを定義
    /** B列 */
    val bLine: PannelPair = PannelPair(0 ,createValue(ARRAY_B))
    /** I列 */
    val iLine: PannelPair = PannelPair(1 ,createValue(ARRAY_I))
    /** N列 */
    val nLine: PannelPair = PannelPair(2 ,createValue(ARRAY_N))
    /** G列 */
    val gLine: PannelPair = PannelPair(3 ,createValue(ARRAY_G))
    /** O列 */
    val oLine: PannelPair = PannelPair(4 ,createValue(ARRAY_O))
    
    // 配列 [B ,I ,N ,G ,O]
    return arrayOf(bLine ,iLine ,nLine ,gLine ,oLine)    
}

/** pannelに作成した同値なしの値をセットする */
fun setValueForPannel(pannel: PannelArray ,array: Array<PannelPair>): PannelArray {
    array.forEach() { (index ,list) ->
        for (i in 0..(HEIGHT - 1)) {
            pannel.setPannelValue(i ,index ,list.get(i))
        }
    }
    
    // 中央のマスをfreeに変更する
    pannel.setPannelValue(HEIGHT_CENTER ,WIDTH_CENTER ,PANNEL_CENTER)
    return pannel
}

/** 引数のリストからランダムで5つ値を取り出し、temp_setに値を代入する */
fun createValue(array: List<Int>): List<Int> {
    // ミュータブルなリストを初期化
    var list: MutableList<Int> = mutableListOf()
    // 一意の値を取得するためのSetコレクション
    var temp_set = mutableSetOf<Int>()
    
    // temp_setに追加できる値が引数のリストからなくなったら無限ループ
    do {
        // 引数のリストからランダムにひとつ値を取得する
        val num = randamizeValue(array)
        
        // temp_setに値を追加する
        // 追加できなかったらすでに登録済みなのでcontinueで、次の値を取得する
        if(!temp_set.add(num)) continue
        
        // temp_setに値が追加できたらlistに値を追加
        list.add(num)
    // listのサイズが、pannelの縦列分になるまでループする
    }while(list.size < HEIGHT)
    
    // 同値を持たないリストを返却
    return list
}

