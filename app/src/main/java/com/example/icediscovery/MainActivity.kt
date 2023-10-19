package com.example.icediscovery


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch and parse JSON data using Kotlin coroutines
        // Use Dispatchers.IO for network operations
        GlobalScope.launch(Dispatchers.Main) {
            val jsonData = withContext(Dispatchers.IO) {
                URL("https://opsc.azurewebsites.net/Dis.php").readText()
            }
            val userListType = object : TypeToken<List<User>>() {}.type
            val userData: List<User> = Gson().fromJson(jsonData, userListType)

            userAdapter = UserAdapter(userData) { user -> showUserDetails(user) }
            recyclerView.adapter = userAdapter
        }
    }

    private fun showUserDetails(user: User) {
        val intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra("user", Gson().toJson(user))
        startActivity(intent)
    }
}

