package com.example.icediscovery

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun userAdapterTest() {
        // Create a sample list of users
        val userList = listOf(
            User("John", "Doe", 1, 100),
            User("Jane", "Smith", 2, 200)
        )

        // Create a UserAdapter with the sample user list
        val userAdapter = UserAdapter(userList) { /* Do nothing for now */ }

        // Test the getItemCount() function
        assertEquals(2, userAdapter.itemCount)

        // Test the bind function of UserViewHolder
        val viewHolder = UserAdapter.UserViewHolder(userAdapter.itemView)
        viewHolder.bind(userList[0])
        assertEquals("John", viewHolder.nameTextView.text)

        viewHolder.bind(userList[1])
        assertEquals("Jane", viewHolder.nameTextView.text)
    }
}

