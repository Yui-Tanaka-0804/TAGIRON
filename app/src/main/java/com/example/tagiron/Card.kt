package com.example.tagiron

/**
 * 質問カード
 */
interface Card{
    val questionStr: String     // 質問文

    /**
     * カードの動作
     * @param hand: List<NumberTile> プレイヤーの手元の数字タイル
     * @return String 質問に対する回答の文章
     */
    fun action(hand: List<NumberTile>): String
}