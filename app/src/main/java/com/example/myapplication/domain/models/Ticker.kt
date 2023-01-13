package com.example.myapplication.domain.models

import java.math.BigDecimal

data class Ticker(
    val name: String,
    val ticker: String,
    val count: Int,
    val initBid: BigDecimal,
    val initAsk: BigDecimal,
    val currentBid: BigDecimal = initBid,
    val currentAsk: BigDecimal = initAsk,
)
