package vcmsa.sibongakonke.historyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            } // code from chatgpt  CODE starts here

        val tvResults: TextView = findViewById(R.id.tvResult)

        // 2) Retrieve Intent extras (defaults if missing)
        val username       = intent.getStringExtra("EXTRA_USERNAME") ?: "Player"
        val score          = intent.getIntExtra("EXTRA_SCORE", 0)
        val totalQuestions = intent.getIntExtra("EXTRA_TOTAL_QUESTIONS", 0)

        // 3) Build the result string
        val resultText = "Congratulations, $username!\nYour Score: $score / $totalQuestions"

        // 4) Display it
        tvResults.text = resultText

        }
}//code ends here
