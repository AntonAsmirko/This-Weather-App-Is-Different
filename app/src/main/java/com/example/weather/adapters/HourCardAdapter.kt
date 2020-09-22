package com.example.weather.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.HourCard

class HourCardAdapter(private val hourCardList: List<HourCard>, private val context: Context) :
    RecyclerView.Adapter<HourCardAdapter.HourHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourCardAdapter.HourHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.hour_holder_layout, parent, false)
        return HourHolder(view)
    }

    override fun getItemCount(): Int {
        return hourCardList.size
    }

    override fun onBindViewHolder(holder: HourCardAdapter.HourHolder, position: Int) {
        val hourCard: HourCard = hourCardList[position]
        holder.setData(hourCard.time, hourCard.img, hourCard.temperature)
    }

    inner class HourHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val timeData = itemView.findViewById<TextView>(R.id.hour_time)
        private val image = itemView.findViewById<ImageView>(R.id.hour_image)
        private val temperature = itemView.findViewById<TextView>(R.id.hour_temperature)

        fun setData(time: String, img: Int, temperature: String) {
            timeData.text = time
            image.setImageBitmap(BitmapFactory.decodeResource(context.resources, img))
            this.temperature.text = temperature
        }
    }
}