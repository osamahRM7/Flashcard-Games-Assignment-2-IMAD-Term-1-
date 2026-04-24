package com.example.myapplication

import android.content.Intent // Make sure this import is here
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AnswerTheQusation : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private var score = 0 // 1. Added score tracker
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

        updateQuestion(textQusation)

        btnTrue.setOnClickListener {
            checkAnswer(true, textQusation)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false, textQusation)
        }
    }

    private fun updateQuestion(textView: TextView) {
        if (currentQuestionIndex < questionList.size) {
            textView.text = questionList[currentQuestionIndex].text
        } else {
            // 2. Launch the ResultPage when questions are finished
            val intent = Intent(this, ResultPage::class.java)
            intent.putExtra("RESULT", score) // Pass the actual score
            startActivity(intent)
            finish() // Close this activity
        }
    }

    private fun checkAnswer(userChoice: Boolean, textView: TextView) {
        val correctAnswer = questionList[currentQuestionIndex].answer

        if (userChoice == correctAnswer) {
            score++ // 3. Increase score if correct
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }

        currentQuestionIndex++
        updateQuestion(textView)
    }
}

