package model

import constant.Constant

data class Card(
    val suit: Suit,
    val rank: Rank
) {
    enum class Suit(val title: String) {
        HEART("하트"),
        DIAMOND("다이아몬드"),
        SPADE("스페이드"),
        CLUB("클로버")
    }

    enum class Rank(val `val`: String) {
        ACE("A"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K")
    }

    companion object {
        fun isAce(rank: Rank): Boolean = Rank.ACE == rank

        fun getRankValue(rank: Rank): Int {
            return when (rank) {
                Rank.ACE -> Constant.ACE_VALUE
                Rank.JACK, Rank.QUEEN, Rank.KING -> Constant.JACK_QUEEN_KING_VALUE
                else -> rank.`val`.toInt()
            }
        }

        fun valueOf(index: Int): Card {
            val suitIndex = index / Rank.values().size
            val rankIndex = index % Rank.values().size
            return Card(Suit.values()[suitIndex], Rank.values()[rankIndex])
        }
    }
}