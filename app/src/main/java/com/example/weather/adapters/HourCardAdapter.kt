package com.example.weather.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.HourCard


class HourCardAdapter(
    private val hourCardList: List<HourCard>,
    private val context: Context,
    private val isVertical: Boolean
) :
    RecyclerView.Adapter<HourCardAdapter.HourHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourCardAdapter.HourHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(
            if (isVertical) R.layout.hour_holder_layout else R.layout.hour_holder_landscape,
            parent,
            false
        )
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
        private val dummyView = itemView.findViewById<View>(R.id.dummyView)

        fun setData(time: String, img: Int, temperature: String) {
            itemView.setOnClickListener {
                setPadding(if (isVertical) 0 else 20)
            }
            timeData.text = time
            image.setImageBitmap(BitmapFactory.decodeResource(context.resources, img))
            this.temperature.text = temperature
        }

        private fun setPadding(sizeInDp: Int) {
            val scale: Float = context.resources.displayMetrics.density
            val dpAsPixels = (sizeInDp * scale + 0.5f).toInt()

            val linearLayoutParams = if (isVertical) LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                dpAsPixels
            ) else LinearLayout.LayoutParams(
                dpAsPixels,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            dummyView.layoutParams = linearLayoutParams
        }
    }
}