package com.example.functiontest


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_card_view.*

class CardViewActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        when (seekBar?.id) {
            R.id.seek_bar_1 -> card_view.radius = progress.toFloat()
            R.id.seek_bar_2 -> card_view.cardElevation = progress.toFloat()
            R.id.seek_bar_3 -> card_view.setContentPadding(progress, progress, progress, progress)
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)
        seek_bar_1.setOnSeekBarChangeListener(this)
        seek_bar_2.setOnSeekBarChangeListener(this)
        seek_bar_3.setOnSeekBarChangeListener(this)

    }
}