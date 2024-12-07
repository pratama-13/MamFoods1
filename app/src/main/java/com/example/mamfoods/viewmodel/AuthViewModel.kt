package com.example.mamfoods.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mamfoods.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

open class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val database: DatabaseReference =
        FirebaseDatabase.getInstance().reference.child("Users")

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        // Langsung panggil onLoginSuccess meskipun email dan password tidak valid
        onSuccess()
    }


    fun register(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid ?: return@addOnCompleteListener
                    val user = User(
                        id = userId,
                        email = email,
                        displayName = name,
                        role = "user",  // This can be modified for multi-role users
                        profileImageUrl = null
                    )
                    database.child(userId).setValue(user).addOnCompleteListener { dbTask ->
                        if (dbTask.isSuccessful) {
                            onSuccess()
                        } else {
                            onError(dbTask.exception?.message ?: "Failed to save user data.")
                        }
                    }
                } else {
                    onError(task.exception?.message ?: "Registration failed.")
                }
            }
    }
}
