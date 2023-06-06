package com.ics342.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Creating objects to get the editText and the button to add functions to them
        val checkString = findViewById<EditText>(R.id.editTextText)
        val buttonOnClick = findViewById<Button>(R.id.ShowButton)

        val input = checkString.text.toString()


        buttonOnClick.setOnClickListener{
            val dialogPopUp = AlertDialog.Builder(this)

            if(input.isEmpty()){
                dialogPopUp.setTitle("Error")
                dialogPopUp.setMessage("Enter some text in the text field.")
            }else {
                dialogPopUp.setTitle("Entered Text")
                dialogPopUp.setMessage(input)
            }


            dialogPopUp.setPositiveButton("ok",null)
            // Create the AlertDialog
            val alertDialog: AlertDialog = dialogPopUp.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

        }
    }

    private fun handleButtonClick() {
        /** Implement the functionality to display the alert here. **/
    }

    private fun showTextInAlert(text: String) {
        AlertDialog
            .Builder(this)
            .setTitle(R.string.entered_text)
            .setMessage(text)
            .setPositiveButton(R.string.okay, null)
            .create()
            .show()
    }

    private fun showErrorAlert() {
        AlertDialog
            .Builder(this)
            .setTitle(R.string.error_title)
            .setMessage(R.string.error_message)
            .setPositiveButton(R.string.okay, null)
            .create()
            .show()
    }
}
