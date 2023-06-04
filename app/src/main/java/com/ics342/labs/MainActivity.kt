package com.ics342.labs

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val text = editText.text.toString()
        if (text.isNotEmpty()) {
            showTextInAlert(text)
        } else {
            showErrorAlert()
        }
    }

    private fun showTextInAlert(text: String) {
        AlertDialog.Builder(this)
            .setTitle("Entered text")
            .setMessage(text)
            .setPositiveButton("Okay", null)
            .create()
            .show()
    }

    private fun showErrorAlert() {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage("Enter some text in the text field.")
            .setPositiveButton("Okay", null)
            .create()
            .show()
    }
}