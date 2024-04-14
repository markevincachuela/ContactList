package com.example.contactlist.feature_contact.domain.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey val id : Int? = null,
    val name: String,
    val content: String,
    @DrawableRes val image: Int,
    val mobileNumber: String,
    val timestamp: Long,
)


class InvalidContactExeption(message: String): Exception(message)