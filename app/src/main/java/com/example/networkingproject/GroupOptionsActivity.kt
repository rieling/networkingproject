package com.example.networkingproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GroupOptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_options)

        val btnCreateGroup: Button = findViewById(R.id.btnCreateGroup)
        val inputGroupCode: EditText = findViewById(R.id.inputGroupCode)
        val btnJoinGroupConfirm: Button = findViewById(R.id.btnJoinGroupConfirm)

        btnCreateGroup.setOnClickListener {
            // Generate a random 6-digit group code
            val groupCode = Random.nextInt(100000, 999999)

            // Log for debugging
            println("Group created with code: $groupCode")

            // Save the group code temporarily or in SharedPreferences (for simplicity here)
            val intent = Intent(this, GroupChatActivity::class.java)
            intent.putExtra("groupCode", groupCode.toString())
            startActivity(intent)
        }


        btnJoinGroupConfirm.setOnClickListener {
            // Get the entered group code
            val groupCode = inputGroupCode.text.toString()

            // Validate the group code (for simplicity, we assume all inputs are valid)
            val intent = Intent(this, GroupChatActivity::class.java)
            intent.putExtra("groupCode", groupCode)
            startActivity(intent)
        }
    }
}
