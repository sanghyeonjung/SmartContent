package com.example.a3gradesmartcontent.Login

import com.google.firebase.auth.FirebaseAuth

object UtilCode {
    fun getInstance() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }
}