package lotto.domain

import lotto.Lotto

enum class Prize(val matchingNumbers: Int, val prizeAmount: Int) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000)
}

class LottoRanks {

    val results = mutableMapOf<Prize, Int>()
    init {
        Prize.entries.forEach { results[it] = 0 }
    }
    fun rank(lottoList: List<Int>, lotto: Lotto, bonusNumber: Int): MutableMap<Prize, Int> {
        val winningNumbers = lottoList // 예시로 고정된 당첨 번호
        val bonusNumber = bonusNumber // 예시로 고정된 보너스 번호
        val userNumbers = lotto.getLotto() // 예시로 고정된 참가자 번호

        val matchedNumbers = checkMatchingNumbers(winningNumbers, userNumbers)

        return results
    }

    private fun checkMatchingNumbers(winningNumbers: List<Int>, userNumbers: List<Int>): Int{
        var matchedNumbers = 0
        userNumbers.forEach {
            if (it in winningNumbers) {
                matchedNumbers++
            }
        }
        return matchedNumbers
    }
}
