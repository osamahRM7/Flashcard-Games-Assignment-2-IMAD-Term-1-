package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnMath = findViewById<Button>(R.id.btnMath)
        val btnSport = findViewById<Button>(R.id.btnSport)
        val btnHistory = findViewById<Button>(R.id.btnHistory)

        btnMath.setOnClickListener {
            val intent = Intent(this, AnswerTheQusation::class.java)
            intent.putExtra("gameType", "Math")
            startActivity(intent)
        }

        btnSport.setOnClickListener {
            val intent = Intent(this, AnswerTheQusation::class.java)
            intent.putExtra("gameType", "Sport")
            startActivity(intent)
        }
        btnHistory.setOnClickListener {
            val intent = Intent(this, AnswerTheQusation::class.java)
            intent.putExtra("gameType", "History")
            startActivity(intent)
        }
    }
}