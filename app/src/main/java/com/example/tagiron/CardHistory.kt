package com.example.tagiron

/**
 * 回答履歴
 *
 * @param questionStr 質問カードの文章
 * @param name 質問者の名前
 * @param answerStr 回答の文章
 */
class CardHistory(private val questionStr: String, val name: String, val answerStr: String)