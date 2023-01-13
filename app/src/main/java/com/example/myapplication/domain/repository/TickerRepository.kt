package com.example.myapplication.domain.repository

import com.example.myapplication.domain.models.Ticker
import kotlinx.coroutines.flow.Flow

interface TickerRepository {

    fun observeByTicker(ticker: String): Flow<Ticker>
}
