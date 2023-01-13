package com.example.myapplication.presentation.feature.detail

import com.example.myapplication.domain.models.Ticker
import java.math.BigDecimal

object PLCalculator {

    fun calculate(ticker: Ticker): BigDecimal {
        return calculate(ticker.currentBid, ticker.initAsk, ticker.count)
    }

    fun calculate(
        currentBid: BigDecimal,
        initAsk: BigDecimal,
        count: Int,
    ): BigDecimal {
        return currentBid.minus(initAsk).times(BigDecimal(count))
    }
}
