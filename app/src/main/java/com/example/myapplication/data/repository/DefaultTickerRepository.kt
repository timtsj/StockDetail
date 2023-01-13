package com.example.myapplication.data.repository

import com.example.myapplication.domain.models.Ticker
import com.example.myapplication.domain.repository.TickerRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import java.math.BigDecimal

class DefaultTickerRepository : TickerRepository {

    private val tickers = listOf(
        Ticker(
            name = "Apple Inc",
            ticker = "AAPL",
            count = 5,
            initBid = BigDecimal("145.99"),
            initAsk = BigDecimal("146.43"),
        ),
    )

    override fun observeByTicker(ticker: String): Flow<Ticker> {
        return flow {
            while (true) {
                delay(3_000)
                val foundTicker = tickers.find { it.ticker == ticker }
                val newBid = (14_400..15_500).random().div(100.0)
                emit(foundTicker?.copy(
                    currentBid = newBid.toBigDecimal(),
                    currentAsk = newBid.plus(0.5).toBigDecimal(),
                ))
            }
        }
            .filterNotNull()
    }
}
