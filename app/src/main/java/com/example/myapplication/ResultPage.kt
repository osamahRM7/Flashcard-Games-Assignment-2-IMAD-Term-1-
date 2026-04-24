package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resulte_page)

        val textResult = findViewById<TextView>(R.id.textResult)
        val textMessage = findViewById<TextView>(R.id.textMessage)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val result = intent.getIntExtra("RESULT", 0)
        textResult.text = "Your Final Score: $result / 5"

        if (result >= 3) {
            textMessage.text = "You did great! "
        } else {
            textMessage.text = "Keep trying! "
        }











    }
}