package com.example.tagiron

/**
 * 数字カードの山札
 */
class CardDeck{
    // いずれ山札の枚数変えたりしたいからめんどくさいことしてる
    val cardDeck = mutableListOf<Card>()    // 数字カードの山札
    val cardColor = arrayOf("Red", "Blue", "Yellow")    //使用する色(黄色は最後に配置する)
    val cardNum = Pair(0, 9)    // カードの最小、最大値
    val cardMiddleNum = cardNum.second - cardNum.first / 2 + 1  // 中央の数字(5)

    /**
     * 初期化時に山札を作成
     */
    init{
        // 数字カードの山札を作成
        // 色ごとに作る
        for (color in 0..cardColor.count()-2) {
            // 数字は指定した範囲で作る
            for (number in cardNum.first..cardNum.second) {
                // 数字が5の時だけ黄色にする
                cardDeck.add(Card(number, cardColor[if (number == cardMiddleNum) cardColor.count()-1 else color]))
            }
        }
        //数字カードをシャッフルしておく
        cardDeck.shuffle()
    }

    /**
     * 数字カードを取得
     *
     * @arg num 取得する数字カードの枚数
     * @return 取得した数字カードの配列
     */
    fun getCards(num: Int): List<Card>{
        // 数字カードを指定された枚数取得する
        val getCards = cardDeck.take(num)
        // 取得されたカードは破棄(もっといい方法ある気がする)
        cardDeck.drop(num)

        // 取得したカードを戻り値にする
        return getCards
    }
}