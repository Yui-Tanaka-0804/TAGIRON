package com.example.tagiron

/**
 * 質問カードの山札
 */
class CardDeck {
    private var cardDeck = listOf<Card>()    // 質問カードの山札

    /**
     * 初期化時に山札を作成
     */
    init {
        val initCardDeck = mutableListOf<Card>()   // 質問カードの山札(初期化用)

        // 質問カードの山札を作成
        initCardDeck.add(CardNumRed())
        initCardDeck.add(CardNumRed())
        // 質問カードをシャッフルしておく
        initCardDeck.shuffle()

        // プロパティに代入
        cardDeck = initCardDeck
    }

    /**
     * 質問カードを取得
     *
     * @arg num 取得する質問カードの枚数
     * @return 取得した質問カードの配列
     */
    fun getCards(num: Int): List<Card>{
        // 質問カードを指定された枚数取得する
        val getCards = cardDeck.take(num)
        // 取得されたカードは破棄(もっといい方法ある気がする)
        cardDeck = cardDeck.drop(num)

        // 取得したカードを戻り値にする
        return getCards
    }

    /**
     * 質問カードを一枚取得
     *
     * @return 取得した質問カード(山札が尽きた場合はnullを返す)
     */
    fun getCard(): Card?{
        // 質問カードを一枚取得する(山札が尽きている場合はnull)
        val getCard = cardDeck.firstOrNull()

        // カードの取得に成功した場合
        if (getCard != null) {
            // 取得されたカードは破棄
            cardDeck = cardDeck.drop(1)
        }

        // 取得したカード(山札が尽きている場合はnull)を戻り値にする
        return getCard
    }
}