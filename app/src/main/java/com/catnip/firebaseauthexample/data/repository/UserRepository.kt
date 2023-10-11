package com.catnip.firebaseauthexample.data.repository

import com.catnip.firebaseauthexample.data.network.firebase.auth.FirebaseAuthDataSource
import com.catnip.firebaseauthexample.utils.ResultWrapper
import com.catnip.firebaseauthexample.utils.proceedFlow
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun isLoggedIn():Boolean
    fun getCurrentUser(): FirebaseUser?
    fun doLogout():Boolean
    suspend fun doRegister(fullName:String,email:String,password:String): Flow<ResultWrapper<Boolean>>
    suspend fun doLogin(email:String,password:String):Flow<ResultWrapper<Boolean>>
}

class UserRepositoryImpl(private val dataSource: FirebaseAuthDataSource):UserRepository{
    override fun isLoggedIn(): Boolean {
        return dataSource.isLoggedIn()
    }

    override fun getCurrentUser(): FirebaseUser? {
        TODO("Not yet implemented")
    }

    override fun doLogout(): Boolean {
        return dataSource.doLogout()
    }

    override suspend fun doRegister(
        fullName: String,
        email: String,
        password: String
    ): Flow<ResultWrapper<Boolean>> {
        TODO("Not yet implemented")
    }

    override suspend fun doLogin(email: String, password: String): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.doLogin(email, password) }
    }
}