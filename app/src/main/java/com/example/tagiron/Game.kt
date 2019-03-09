package com.example.tagiron

/**
 * ゲーム本体
 */
class Game{
    private val cardDeck = CardDeck()   // 質問カード
    private val player = mutableListOf<Player>()    // プレイヤー
    private val fieldCard = mutableListOf<Card>()   // 場に出ているカード
    val cardHistory = mutableListOf<CardHistory>()   // 回答の履歴

    var turns = 1   // 現在のターン数

    init{
        // 数字タイルを用意する
        val numberTileDeck = NumberTileDeck()

        // プレイヤー人数は仮に２人とする
        player.add(Player("Player1", numberTileDeck.getTiles(5)))
        player.add(Player("Player2", numberTileDeck.getTiles(5)))

        // 質問カードを6枚場に並べる
        for (i in 0..5){
            drawCard()
        }
    }

    /**
     * 質問カードを一枚引く
     */
    private fun drawCard(){
        // 山札から質問カードを一枚引く
        val card = cardDeck.getCard()

        // 山札が無くなっている場合はnullが返ってきているので何もしない
        if (card != null) {
            fieldCard += card
        }
    }

    /**
     * プレイヤーの手札を取得する
     *
     * @param num プレイヤーの番号
     * @return 選択したプレイヤーの手札
     */
    fun getPlayerHand(num: Int): List<NumberTile>{
        // 選択されたプレイヤーの手札を返す
        return player[num].checkHand()
    }

    /**
     * 場に出ている質問カードの文章を取得する
     *
     * @return 場に出ている質問カードの文章
     */
    fun getFieldCard(): List<String>{
        val getFieldCard = mutableListOf<String>()  // 質問カードの文章を格納する配列

        // 場に出ている質問カードの文章を配列に格納
        for (card in fieldCard){
            getFieldCard.add(card.questionStr)
        }

        // 取得した結果の配列を返す
        return getFieldCard
    }

    /**
     * 質問カードを選択したときの処理
     *
     * @param num 選択したカードの添え字(0..)
     */
    fun selectCard(num: Int){
        val selectCard = fieldCard[num] // 選択されたカード
        val currentPlayer = player[(turns-1) / player.count()]  // 現在のプレイヤー

        // 自分以外のプレイヤーに対して質問する
        for (player in player){
            if (player != currentPlayer){
                // 質問した結果は履歴に格納する
                cardHistory.add(CardHistory(selectCard.questionStr, currentPlayer.name, currentPlayer.answer(selectCard)))
            }
        }

        // 使用したカードを削除
        fieldCard.removeAt(num)

        // 質問カードを補充する
        drawCard()

        // ターンを進める
        turns++
    }
}