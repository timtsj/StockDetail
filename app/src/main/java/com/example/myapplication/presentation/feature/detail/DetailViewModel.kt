package com.example.myapplication.presentation.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MainApp
import com.example.myapplication.domain.interactor.TickerInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

class DetailViewModel(
    private val tickerInteractor: TickerInteractor = TickerInteractor(MainApp.tickerRepository),
    private val detailDvoMapper: DetailDvoMapper = DetailDvoMapper(),
    private val ioContext: CoroutineContext = Dispatchers.IO,
) : ViewModel() {

    val ticker = MutableStateFlow<DetailDvo?>(null)

    init {
        observeTicker()
    }

    private fun observeTicker() {
        tickerInteractor.observeByTicker("AAPL")
            .map(detailDvoMapper::toDetailDvo)
            .flowOn(ioContext)
            .onEach { ticker.value = it }
            .launchIn(viewModelScope)
    }
}
