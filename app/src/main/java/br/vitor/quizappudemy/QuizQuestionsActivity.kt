package br.vitor.quizappudemy

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.random.Random

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {

    private var currentPosition = 1
    private lateinit var mQuestions: ArrayList<Question>
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers:Int = 0

    private var mUsername:String? = null
    private lateinit var progressbar:ProgressBar
    private lateinit var tvProgress :TextView
    private lateinit var tvQuestion :TextView
    private lateinit var ivImage :ImageView
    private lateinit var btnSubmit :Button
    private lateinit var tvOptionOne:TextView
    private lateinit var tvOptionTwo:TextView
    private lateinit var tvOptionThree:TextView
    private lateinit var tvOptionFour:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        progressbar =findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        ivImage = findViewById(R.id.iv_question)
        btnSubmit = findViewById(R.id.btn_submit)
        tvQuestion = findViewById(R.id.tv_question)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)

//        Mesma coisa de colocar no layout da activity
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        mQuestions = getRandomQuestions()

        setQuestion()

    }
// Extra funcionality
    private fun getRandomQuestions(): ArrayList<Question>{
        val randomQuestions:ArrayList<Question> = arrayListOf()
        do{
            val questions = Constants.getQuestions()
            val random = Random.nextInt(Constants.getQuestions().size)
            if(randomQuestions.contains(questions[random]).not()) {
                randomQuestions.add(questions[random])
            }
        } while (randomQuestions.size != 10)


        return randomQuestions
    }

    private fun setQuestion() {
        defaultOptionsView()
        //        Para mostra no console e testar. Isso mostra no LogCat
        Log.i("QuestionsLists size is:", "${mQuestions.size}")
        //      Pra mostrar no console as questões como erro
        for (i in mQuestions) {
            Log.e("Question", i.question)
        }
        val question: Question = mQuestions[currentPosition - 1]

        progressbar.progress = currentPosition
        ivImage.setImageResource(question.image)
        tvProgress.text = "$currentPosition/${progressbar.max}"
        tvQuestion.text = question.question
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour


        btnSubmit.text = "SUBMIT"


    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne.let {
            options.add(0,it)
        }
        tvOptionTwo.let {
            options.add(1,it)
        }
        tvOptionThree.let {
            options.add(2,it)
        }
        tvOptionFour.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum:Int){
        defaultOptionsView()

        mSelectedOptionPosition =selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background=  ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one->{
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option_two->{
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_three->{
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_four->{
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition == 0){
                    currentPosition++

                    when{
                        currentPosition<=mQuestions.size->{
                            setQuestion()
                        }
                        else->{
                            Toast.makeText(
                                this,
                                "You made to the end!!",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            val resultIntent = Intent(
                                this,
                                ResultActivity::class.java
                            )
                            resultIntent.putExtra(Constants.USER_NAME, mUsername)
                            resultIntent.putExtra(Constants.TOTAL_QUESTIONS, mQuestions.size)
                            resultIntent.putExtra(Constants.CORRECT_QUESTIONS,mCorrectAnswers)

                            startActivity(resultIntent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestions[currentPosition-1]
                    if (question.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (currentPosition == mQuestions.size){
                        btnSubmit.text = "FINISH"
                    }else{
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }
    }
    private fun answerView(answer:Int , drawableView:Int){
        when(answer){
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvOptionTwo.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3->{
                tvOptionThree.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4->{
                tvOptionFour.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}