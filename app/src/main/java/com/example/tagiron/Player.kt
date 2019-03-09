package com.example.tagiron

/**
 * プレイヤーの行動
 *
 * @param hand 手札の数字タイル
 */
class Player(val name:String, private val hand: List<NumberTile>){

    /**
     * 選択されたカードへの回答
     *
     * @param card 選択されたカード
     * @return 回答文
     */
    fun answer(card: Card): String{
        return card.action(hand)
    }

    fun checkHand(): List<NumberTile>{
        return hand
    }
}
