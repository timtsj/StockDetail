package com.example.myapplication.presentation.feature.detail

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class PLCalculatorTest {

    private val calculator = PLCalculator

    @Test
    fun calculate_isCorrect() {
        val currentBid = BigDecimal("2.0")
        val initAsk = BigDecimal("1.0")
        val count = 5
        assertEquals(BigDecimal("5.0"), calculator.calculate(currentBid, initAsk, count))
    }
}
