package com.example.myapplication.presentation.feature.detail

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val vName get() = findViewById<TextView>(R.id.symbol)
    private val vPL get() = findViewById<TextView>(R.id.profitAndLoss)
    private val vBidAndAsk get() = findViewById<TextView>(R.id.bidAndAsk)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeTicker()
    }

    private fun observeTicker() {
        lifecycleScope.launchWhenStarted {
            viewModel.ticker
                .filterNotNull()
                .onEach {
                    vName.text = it.name
                    vPL.text = getString(R.string.pl_args, it.pl)
                    vBidAndAsk.text = getString(R.string.bid_and_ask_args, it.bid, it.ask)
                }
                .flowWithLifecycle(lifecycle)
                .collect()
        }
    }
}
