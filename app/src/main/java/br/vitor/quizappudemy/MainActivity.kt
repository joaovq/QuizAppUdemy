package br.vitor.quizappudemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart :Button
    private lateinit var etName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.btn_start)
        etName = findViewById(R.id.app_txt_edit)
        btnStart.setOnClickListener{
            if (etName.text.isEmpty()){
                Toast.makeText(this, "Enter your name to start", Toast.LENGTH_LONG).show()
            }
            else{
                val intent =Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

}