package com.example.panvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPan = findViewById<EditText>(R.id.etPan)
        val etPincode = findViewById<EditText>(R.id.etPincode)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {

            val pan = etPan.text.toString().trim()
            val pincode = etPincode.text.toString().trim()

            // i) Check empty fields
            if (pan.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ii) PAN validation: Alphanumeric and exactly 10 characters
            val panRegex = Regex("^[A-Za-z0-9]{10}$")
            if (!pan.matches(panRegex)) {
                etPan.error = "PAN must be 10 alphanumeric characters"
                return@setOnClickListener
            }

            // iii) Pincode validation: Exactly 6 digits
            val pinRegex = Regex("^\\d{6}$")
            if (!pincode.matches(pinRegex)) {
                etPincode.error = "Pincode must be exactly 6 digits"
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful!", Toast.LENGTH_SHORT).show()
        }
    }
}