package com.example.myapplication.domain.interactor

import com.example.myapplication.domain.models.Ticker
import com.example.myapplication.domain.repository.TickerRepository
import kotlinx.coroutines.flow.Flow

class TickerInteractor(
    private val tickerRepository: TickerRepository,
) {

    fun observeByTicker(ticker: String): Flow<Ticker> {
        return tickerRepository.observeByTicker(ticker)
    }
}
