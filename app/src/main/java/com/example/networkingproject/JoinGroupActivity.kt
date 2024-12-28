package com.example.networkingproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class JoinGroupActivity : AppCompatActivity() {

    private lateinit var inputGroupCode: EditText
    private lateinit var btnJoinGroup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_group)

        inputGroupCode = findViewById(R.id.inputGroupCode)
        btnJoinGroup = findViewById(R.id.btnJoinGroup)

        // Button to join the group
        btnJoinGroup.setOnClickListener {
            val groupCode = inputGroupCode.text.toString()
            if (groupCode.isNotEmpty()) {
                // Pass the entered group code to GroupChatActivity
                val intent = Intent(this, GroupChatActivity::class.java)
                intent.putExtra("groupCode", groupCode)
                startActivity(intent)
            }
        }
    }
}
