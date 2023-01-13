package com.example.myapplication

import android.app.Application
import com.example.myapplication.data.repository.DefaultTickerRepository
import com.example.myapplication.domain.repository.TickerRepository

class MainApp : Application() {

    companion object {
        lateinit var tickerRepository: TickerRepository
    }

    override fun onCreate() {
        super.onCreate()
        tickerRepository = DefaultTickerRepository()
    }
}
