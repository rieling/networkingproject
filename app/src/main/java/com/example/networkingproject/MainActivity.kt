package com.example.networkingproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnCreateGroup: Button
    private lateinit var btnJoinGroup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateGroup = findViewById(R.id.btnCreateGroup)
        btnJoinGroup = findViewById(R.id.btnJoinGroup)

        // Button to create a new group
        btnCreateGroup.setOnClickListener {
            val intent = Intent(this, CreateGroupActivity::class.java)
            startActivity(intent)
        }

        // Button to join an existing group
        btnJoinGroup.setOnClickListener {
            val intent = Intent(this, JoinGroupActivity::class.java)
            startActivity(intent)
        }
    }
}
