package com.ics342.labs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            handleButtonClick()
        }
    }

    private fun handleButtonClick() {
        val enteredText = editText.text.toString()

        if (enteredText.isEmpty()) {
            showErrorAlert()
        } else {
            showTextInAlert(enteredText)
        }
    }

    private fun showTextInAlert(text: String) {
        AlertDialog.Builder(this)
            .setTitle("Entered Text")
            .setMessage(text)
            .setPositiveButton("Okay", null)
            .create()
            .show()
    }

    private fun showErrorAlert() {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage("No text entered")
            .setPositiveButton("Okay", null)
            .create()
            .show()
    }
}

