package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class AnswerTheQusation : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>
    data class Question(val text: String, val answer: Boolean)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_answer_the_qusation)

        val textQusation = findViewById<TextView>(R.id.textQusation)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)

        val gameType = intent.getStringExtra("gameType")

                // 2. Load 5 questions based on the category
        questionList = when (gameType) {
            "Math" -> listOf(
                Question("Does 100 + 50 = 145.", false),
                Question("Is 12 - 4 = 8.", true),
                Question("Is 7 + 7 = 12.", false),
                Question("Is 8 + 25 = 33.", true),
                Question("Does 900000 + 10000 = 1000000 .", false)
            )
            "Sport" -> listOf(
                Question("Is Real Madrid Has 15 Champions League.", true),
                Question("Is Lionel Messi the best player in the world.", false),
                Question("Is Ronaldo the best player in the world.", true),
                Question("Is Spring Box the Best Team in the world.", true),
                Question("Is Brazil the best club in the world.", true)
            )
            "History" -> listOf(
                Question("Nelson Mandela became the president of South Africa in 1994.", true),
                Question("World War II ended in 1945.", true),
                Question("The United States declared independence in 1776..", true),
                Question("The Berlin Wall fell in 1991.", false),
                Question("The first human landed on the moon in 1969..", true)
            )
            else -> listOf(Question("Error loading questions", true))
        }








    }
}
