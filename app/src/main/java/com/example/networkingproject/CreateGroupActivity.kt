package com.example.networkingproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CreateGroupActivity : AppCompatActivity() {

    private lateinit var btnCreateGroup: Button
    private lateinit var displayGroupCode: TextView
    private var groupCode: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        btnCreateGroup = findViewById(R.id.btnCreateGroup)
        displayGroupCode = findViewById(R.id.displayGroupCode)

        // Generate a random 6-digit group code
        groupCode = generateGroupCode()
        displayGroupCode.text = "Group Code: $groupCode"

        // Button to create the group and navigate to GroupChatActivity
        btnCreateGroup.setOnClickListener {
            val intent = Intent(this, GroupChatActivity::class.java)
            intent.putExtra("groupCode", groupCode)  // Pass the generated code
            startActivity(intent)
        }
    }

    // Generate a random 6-digit number as the group code
    private fun generateGroupCode(): String {
        val random = Random()
        return String.format("%06d", random.nextInt(1000000))  // 6-digit code
    }
}
