package br.vitor.quizappudemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var btnFinish:Button
    private lateinit var tvName:TextView
    private lateinit var tvScore:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btnFinish = findViewById(R.id.btn_finish)
        tvName = findViewById(R.id.tv_name)
        tvScore = findViewById(R.id.tv_score)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctQuestions = intent.getIntExtra(Constants.CORRECT_QUESTIONS, 0)

        tvScore.text = "Your score $correctQuestions out of $totalQuestions"

        btnFinish.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}