package com.example.myapplication.presentation.feature.detail

import com.example.myapplication.domain.models.Ticker

class DetailDvoMapper {

    fun toDetailDvo(from: Ticker): DetailDvo {
        return DetailDvo(
            name = "${from.name} x${from.count} (${from.initAsk} per share)",
            pl = PLCalculator.calculate(from).toString(),
            bid = from.currentBid.toString(),
            ask = from.currentAsk.toString(),
        )
    }
}
