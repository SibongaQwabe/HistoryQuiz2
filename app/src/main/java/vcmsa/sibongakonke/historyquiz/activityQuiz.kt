package vcmsa.sibongakonke.historyquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activityQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
                data class Question(val text: String, val answer: Boolean)

        class QuizActivity : AppCompatActivity() {

            // code from chat gpt code starts here
            private val questionBank = listOf(
                Question("The Declaration of Independence was signed in 1776.", true),
                Question("Julius Caesar was assassinated on the Ides of March (March 15).", true),
                Question("The Berlin Wall fell in 1989.", true),
                Question("The Magna Carta was signed by King John of England in 1215.", true),
                Question("Christopher Columbus first landed in North America in 1492.", false),
                Question("The Russian Revolution occurred in 1917.", true),
                Question("World War II ended in 1946.", false)
            )

            private var currentIndex = 0


            private lateinit var tvQuizQuestion: TextView
            private lateinit var btnTrue: Button
            private lateinit var btnFalse: Button

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_quiz)


                tvQuizQuestion = findViewById(R.id.tvQuizQuestion)
                btnTrue = findViewById(R.id.btnTrue)
                btnFalse = findViewById(R.id.btnFalse)


                updateQuestionOnTextView(tvQuizQuestion)

                btnTrue.setOnClickListener {

                    moveToNextQuestion(tvQuizQuestion)
                }

                btnFalse.setOnClickListener {

                    moveToNextQuestion(tvQuizQuestion)
                }
            }

            /**
             * 7. Put the current question’s text onto the TextView
             */
            private fun updateQuestionOnTextView(textView: TextView) {
                val questionText = questionBank[currentIndex].text
                textView.text = questionText
            }

            /**
             * 8. Advance index (with wrap‐around) and then update the TextView
             */
            private fun moveToNextQuestion(textView: TextView) {
                currentIndex = (currentIndex + 1) % questionBank.size
                updateQuestionOnTextView(textView)
            }
        }



    }
        }//code ends here

