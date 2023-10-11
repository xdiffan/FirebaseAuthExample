package com.catnip.firebaseauthexample.data.model

import com.google.firebase.auth.FirebaseUser

data class User(
    val fulLName:String,
    val email:String
)

fun FirebaseUser?.toUser():User?=if (this!=null){
    User(
        fulLName = this.displayName.orEmpty(),
        email=this.email.orEmpty()
    )

}else null
