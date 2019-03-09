package com.example.tagiron

/**
 * 質問カード
 * "赤の数字タイルは何枚ある？"
 */
class CardNumRed : Card {
    /**
     * 質問文
     */
    override val questionStr: String = "赤の数字タイルは何枚ある？"

    /**
     * カードの動作
     * @param hand: List<NumberTile> プレイヤーの手元の数字タイル
     * @return String 質問に対する回答の文章
     */
    override fun action(hand: List<NumberTile>): String {
        var redNum = 0  // 赤色のカードの枚数

        // 数字タイルの赤色のタイルの枚数をカウント
        for (numberTile in hand){
            when(numberTile.color){
                "Red" -> {
                    redNum++
                }
            }
        }

        // 結果を戻り値にする
        return "赤色の数字タイルは${redNum}枚です"
    }

}
