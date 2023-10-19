package com.example.icediscovery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val userJson = intent.getStringExtra("user")
        val user = Gson().fromJson(userJson, User::class.java)

       // val user = intent.getSerializableExtra("user") as User

        val textName: TextView = findViewById(R.id.textName)
        val textSurname: TextView = findViewById(R.id.textSurname)
        val textPlanID: TextView = findViewById(R.id.textPlanID)
        val textAmount: TextView = findViewById(R.id.textAmount)

        textName.text = user.Name
        textSurname.text = user.Surname
        textPlanID.text = user.PlanID.toString()
        textAmount.text = user.Amount.toString()
    }
}
