package vcmsa.sibongakonke.historyquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast                                // ← Import Toast!
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var edtUsername: EditText
    private lateinit var btnStartQuiz: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //code from chatgpt code starts here
        edtUsername = findViewById(R.id.edtUsername)
        btnStartQuiz = findViewById(R.id.btnStartQuiz)


        btnStartQuiz.setOnClickListener {

            val username = edtUsername.text.toString().trim()


            if (username.isEmpty()) {

                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val intent = Intent(this, activityQuiz::class.java).apply {
                putExtra("EXTRA_USERNAME", username)
            }
            startActivity(intent)
            //code ends here
        }
    }
}
