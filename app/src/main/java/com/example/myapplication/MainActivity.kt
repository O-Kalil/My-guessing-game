package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {


    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var clearButton:Button

    private var random = nextInt(1,100)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


            button = findViewById(R.id.confirm_button)
            textView = findViewById(R.id.textView)
            editText = findViewById(R.id.editNumber)
            clearButton = findViewById(R.id.clear_button)


            val guess = editText.text.toString()

            button.setOnClickListener {

                val guess = editText.text.toString()

                if (guess.isNotEmpty()){
                    val guess = guess.toInt()

                    if (guess < 1 || guess > 100){
                        textView.text ="Try again with a number between 1 and 100"
                        editText.text.clear()
                    }
                    else if( guess == random){
                        textView.text ="CONGRATULATION, you guested the number "
                        editText.text.clear()
                    }
                    else if ( guess > random) {
                        textView.text = "Your number is GREATER than the ANSWER"
                        editText.text.clear()
                    }
                    else
                        textView.text = "Your number is LESS than the answer"
                    editText.text.clear()
                }
            }
            clearButton.setOnClickListener {
               reset()
            }
        }
    private fun reset(){
        random = nextInt(1,100)
        editText.text.clear()
        textView.text = "Please enter your guess"

    }


}



