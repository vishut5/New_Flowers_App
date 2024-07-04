package com.vishu.newflowers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FlowerAdapter(private val flowers: List<Flower>, private val listener: OnFlowerClickListener) :
    RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

    interface OnFlowerClickListener {
        fun onFlowerClick(flower: Flower)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flower, parent, false)
        return FlowerViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val flower = flowers[position]
        holder.bind(flower)
        holder.itemView.setOnClickListener {
            listener.onFlowerClick(flower)
        }
    }

    override fun getItemCount(): Int {
        return flowers.size
    }

    class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textName: TextView = itemView.findViewById(R.id.textName)

        fun bind(flower: Flower) {
            Glide.with(itemView.context)
                .load(flower.imageUrl)
                .centerCrop()
                .into(imageView)

            textName.text = flower.name
        }
    }
}
