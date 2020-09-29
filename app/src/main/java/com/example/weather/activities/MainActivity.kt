package com.example.weather.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.adapters.HourCardAdapter
import com.example.weather.data.HourCard
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var hoursRecycler: RecyclerView
    private var isLight = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hoursRecycler = findViewById(R.id.hoursRecycler)
        hoursRecycler.scrollBarSize = 0
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        hoursRecycler.layoutManager = layoutManager
        val hoursCardList = listOf(
            HourCard("1AM", R.drawable.cloudy, "4\u02DAC"),
            HourCard("2AM", R.drawable.cloudy, "4\u02DAC"),
            HourCard("3AM", R.drawable.night, "5\u02DAC"),
            HourCard("4AM", R.drawable.night, "6\u02DAC"),
            HourCard("5AM", R.drawable.cloudy, "7\u02DAC"),
            HourCard("6AM", R.drawable.cloudy, "8\u02DAC"),
            HourCard("7AM", R.drawable.sunny, "9\u02DAC"),
            HourCard("8AM", R.drawable.sunny, "11\u02DAC"),
            HourCard("9AM", R.drawable.sunny, "13\u02DAC"),
            HourCard("10AM", R.drawable.sunny, "15\u02DAC"),
            HourCard("11AM", R.drawable.sunny, "15\u02DAC"),
            HourCard("1PM", R.drawable.sunny, "15\u02DAC"),
            HourCard("2PM", R.drawable.sunny, "12\u02DAC"),
            HourCard("3PM", R.drawable.cloudy, "11\u02DAC"),
            HourCard("4PM", R.drawable.cloudy, "9\u02DAC"),
            HourCard("5PM", R.drawable.rainy, "8\u02DAC"),
            HourCard("6PM", R.drawable.rainy, "7\u02DAC"),
            HourCard("7PM", R.drawable.rainy, "6\u02DAC"),
            HourCard("8PM", R.drawable.shtorm, "4\u02DAC"),
            HourCard("9PM", R.drawable.shtorm, "4\u02DAC"),
            HourCard("9PM", R.drawable.shtorm, "4\u02DAC"),
            HourCard("10PM", R.drawable.snowy, "-1\u02DAC"),
            HourCard("11PM", R.drawable.snow, "-2\u02DAC")
        )
        hoursRecycler.adapter = HourCardAdapter(hoursCardList, this)
        chip1.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}