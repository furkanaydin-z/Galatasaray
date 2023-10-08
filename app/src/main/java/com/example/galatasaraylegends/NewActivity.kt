package com.example.galatasaraylegends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val headingnews : TextView = findViewById(R.id.headingnew)
        val mainnews : TextView = findViewById(R.id.textViewnew)
        val imagenews : ShapeableImageView = findViewById(R.id.imageViewnew)

        val bundle : Bundle? = intent.extras
        val heading = bundle!!.getString("heading")
        val imageid = bundle.getInt("imageid")
        val news = bundle.getString("news")

        headingnews.text = heading
        mainnews.text = news
        imagenews.setImageResource(imageid)
    }
}