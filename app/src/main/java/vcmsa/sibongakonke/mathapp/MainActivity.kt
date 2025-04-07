package vcmsa.sibongakonke.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFirst = findViewById<EditText>(R.id.etFirst)
        val etSecond = findViewById<EditText>(R.id.etSecond)
        val resultField = findViewById<EditText>(R.id.answer)

        val addButton = findViewById<Button>(R.id.button)
        val subButton = findViewById<Button>(R.id.button2)

        addButton.setOnClickListener {
            val first = etFirst.text.toString().toDoubleOrNull()
            val second = etSecond.text.toString().toDoubleOrNull()

            if (first != null && second != null) {
                resultField.setText((first + second).toString())
            } else {
                resultField.setText("Invalid input")
            }
        }

        subButton.setOnClickListener {
            val first = etFirst.text.toString().toDoubleOrNull()
            val second = etSecond.text.toString().toDoubleOrNull()

            if (first != null && second != null) {
                resultField.setText((first - second).toString())
            } else {
                resultField.setText("Invalid input")
            }
        }
    }
}
