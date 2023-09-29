package com.example.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val hangman =
        listOf(
            """
    -----
    |   |
    |   o
    |  /|\
    |   |
    |  / \
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |   o
    |  /|\
    |   |
    |  / 
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |   o
    |  /|\
    |   |
    |
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |   o
    |  /|\
    |
    |
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |   o
    |  /|
    |
    |
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |   o
    |  /
    |
    |
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |   o
    |
    |
    |
    |
    -----------
""".trimIndent(),
            """
    -----
    |   |
    |
    |
    |
    |
    |
    -----------
""".trimIndent(),
            """
    -----
    |
    |
    |
    |
    |
    |
    -----------
""".trimIndent(),
            """
    
    |
    |
    |
    |
    |
    |
    -----------
""".trimIndent(),
            """
    
    
    
    
    
    
    
    -----------
""".trimIndent()
        )

    private lateinit var word: String

    private lateinit var status: CharArray

    private var life = hangman.lastIndex

    private var score = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        word = "application"
        status = ".".repeat(word.length).toCharArray()

        val hangmanTextView: TextView = findViewById(R.id.hangmanTextView)
        val checkButton: Button = findViewById(R.id.checkButton)
        val inputEditText: EditText = findViewById(R.id.editTextText)

        checkButton.setOnClickListener {
            val input = inputEditText.text.toString()
            hangmanTextView.text = "$input"

            if (input.length > 1) {
                if (input == word) {
                    status = input.toCharArray()
                } else {
                    life--
                }
            } else if (input in word) {
                word.forEachIndexed { index, c ->
                    if (c in input) {
                        status[index] = c
                    }
                }
            } else {
                life--
            }
            if (life > 0) {
                hangmanTextView.text = "Gratulujeme k vyhre"
            } else {
                hangmanTextView.text = "Prehral si"
            }
        }
        score--
        hangmanTextView.text = "$score"
    }
}