package com.catnip.firebaseauthexample.data.repository

import com.catnip.firebaseauthexample.utils.ResultWrapper
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun isLoggedIn():Boolean
    fun getCurrentUser(): FirebaseUser?
    fun doLogout():Boolean
    suspend fun doRegister(fullName:String,email:String,password:String): Flow<ResultWrapper<Boolean>>
    suspend fun doLogin(email:String,password:String):Flow<ResultWrapper<Boolean>>
}

class UserRepositoryImpl():UserRepository{
    override fun isLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): FirebaseUser? {
        TODO("Not yet implemented")
    }

    override fun doLogout(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun doRegister(
        fullName: String,
        email: String,
        password: String
    ): Flow<ResultWrapper<Boolean>> {
        TODO("Not yet implemented")
    }

    override suspend fun doLogin(email: String, password: String): Flow<ResultWrapper<Boolean>> {
        TODO("Not yet implemented")
    }
}