package com.example.networkingproject

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class GroupChatActivity : AppCompatActivity() {

    private lateinit var displayGroupCode: TextView
    private lateinit var listMembers: ListView
    private lateinit var inputMessage: EditText
    private lateinit var btnSendMessage: Button
    private lateinit var btnLeaveGroup: Button
    private var groupCode: String? = null
    private var members = mutableListOf<String>() // List to store group members
    private var isGroupCreator = false // Flag to check if the user is the group creator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_chat)

        // Get the group code passed from the previous activity
        groupCode = intent.getStringExtra("groupCode")

        // Initialize UI components
        displayGroupCode = findViewById(R.id.displayGroupCode)
        listMembers = findViewById(R.id.listMembers)
        inputMessage = findViewById(R.id.inputMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)
        btnLeaveGroup = findViewById(R.id.btnLeaveGroup)

        // Set the group code in the TextView
        displayGroupCode.text = "Group Code: $groupCode"

        // Set initial group members (for demonstration, this would be dynamically updated)
        members.add("User1") // This would come from a database or shared memory
        members.add("User2")
        members.add("User3")

        // Set up the adapter to display the members in the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, members)
        listMembers.adapter = adapter

        // Send message button functionality
        btnSendMessage.setOnClickListener {
            val message = inputMessage.text.toString().trim()
            if (message.isNotEmpty()) {
                // Logic to send the message (e.g., via socket, Firebase, etc.)
                Toast.makeText(this, "Message sent: $message", Toast.LENGTH_SHORT).show()

                // Optionally update the UI with the sent message (for demo)
                inputMessage.text.clear() // Clear the input field
            }
        }

        // Leave group button functionality
        btnLeaveGroup.setOnClickListener {
            if (isGroupCreator) {
                // If the user is the group creator, delete the group
                // Logic to delete the group (e.g., remove from database)
                Toast.makeText(this, "Group deleted", Toast.LENGTH_SHORT).show()
            } else {
                // If the user is a member, just remove them from the group
                Toast.makeText(this, "You left the group", Toast.LENGTH_SHORT).show()
            }

            // Go back to the previous screen or home
            finish()
        }
    }
}
