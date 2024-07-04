package com.vishu.newflowers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textName: TextView
    private lateinit var textDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        imageView = findViewById(R.id.imageView)
        textName = findViewById(R.id.textName)
        textDescription = findViewById(R.id.textDescription)

        val flower = intent.getParcelableExtra<Flower>("flower")
        flower?.let {
            Glide.with(this)
                .load(it.imageUrl)
                .centerCrop()
                .into(imageView)

            textName.text = it.name
            textDescription.text = it.description
        }
    }
}
