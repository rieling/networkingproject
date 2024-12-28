package com.example.networkingproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val inputDeviceName: EditText = findViewById(R.id.inputDeviceName)
        val btnSaveName: Button = findViewById(R.id.btnSaveName)

        btnSaveName.setOnClickListener {
            val userName = inputDeviceName.text.toString().trim()

            if (userName.isNotEmpty()) {
                // Save the username to SharedPreferences
                val prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)
                prefs.edit().putString("userName", userName).apply()

                // Log for debugging
                Log.d("NameActivity", "UserName saved: $userName")

                // Proceed to the GroupOptionsActivity
                val intent = Intent(this, GroupOptionsActivity::class.java)
                startActivity(intent)
            } else {
                // Show a toast if the name is empty
                Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
