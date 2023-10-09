package com.catnip.firebaseauthexample.data.network.firebase.auth

import androidx.core.net.toUri
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

interface FirebaseAuthDataSource {
    fun isLoggedIn():Boolean
    fun getCurrentUser():FirebaseUser?
    fun doLogout():Boolean
    suspend fun doRegister(fullName:String,email:String,password:String):Boolean
    suspend fun doLogin(email:String,password:String):Boolean
}

class FireBaseAuthDataSourceImpl(private val firebaseAuth:FirebaseAuth):FirebaseAuthDataSource {
    override fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser!=null
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun doLogout(): Boolean {
        Firebase.auth.signOut()
        return true
    }

    override suspend fun doRegister(fullName: String, email: String, password: String): Boolean {
        val registerResult:AuthResult=firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        registerResult.user?.updateProfile(
            userProfileChangeRequest {
                displayName=fullName
//                photoUri="https://www.liputan6.com/hot/read/4105058/6-potret-kucing-bergaya-akrobat-ini-bikin-gemas-ada-yang-kayang#".toUri()
            }
        )?.await()
        return registerResult.user !=null
    }

    override suspend fun doLogin(email: String, password: String): Boolean {
        val loginResult:AuthResult=firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return loginResult.user !=null
    }
}