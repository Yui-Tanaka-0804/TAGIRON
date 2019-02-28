package com.example.tagiron

/**
 * 数字タイルの山札
 */
class NumberTileDeck{
    // いずれ山札の枚数変えたりしたいからめんどくさいことしてる
    val tileDeck = mutableListOf<NumberTile>()    // 数字タイルの山札
    val tileColor = arrayOf("Red", "Blue", "Yellow")    // 使用する色(黄色は最後に配置する)
    val tileNum = Pair(0, 9)    // 数字の最小、最大値
    val tileMiddleNum = tileNum.second - tileNum.first / 2 + 1  // 中央の数字(5)

    /**
     * 初期化時に山札を作成
     */
    init{
        // 数字タイルの山札を作成
        // 色ごとに作る
        for (color in 0..tileColor.count()-2) {
            // 数字は指定した範囲で作る
            for (number in tileNum.first..tileNum.second) {
                // 数字が5の時だけ黄色にする
                tileDeck.add(NumberTile(number, tileColor[if (number == tileMiddleNum) tileColor.count()-1 else color]))
            }
        }
        // 数字タイルをシャッフルしておく
        tileDeck.shuffle()
    }

    /**
     * 数字タイルを取得
     *
     * @arg num 取得する数字タイルの枚数
     * @return 取得した数字タイルの配列
     */
    fun getTiles(num: Int): List<NumberTile>{
        // 数字タイルを指定された枚数取得する
        val getTiles = tileDeck.take(num)
        // 取得されたタイルは破棄(もっといい方法ある気がする)
        tileDeck.drop(num)

        // 取得したタイルを戻り値にする
        return getTiles
    }
}