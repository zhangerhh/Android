package com.example.myapplication4.model
// suit 花色，suit 牌面大小，isChosen 牌面正反，isMatched 匹配
class Card(private var suit: String, private var rank: String, var isChosen:Boolean = false, var isMatched:Boolean = false)  {
    companion object {
        val rankStrings= arrayOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
        val validSuits = arrayOf("♥", "♦", "♠", "♣")
    }

    override fun toString(): String {
        return suit + rank
    }

    fun match(otherCards: Array<Card>): Int {
        var score = 0
        if (otherCards.size == 1) {
            val otherCard = otherCards[0] //otherCards.first()
            if (otherCard.rank == rank) {
                score = 4
            } else if (otherCard.suit == suit) {
                score = 1
            }
        }
        return score
    }
}