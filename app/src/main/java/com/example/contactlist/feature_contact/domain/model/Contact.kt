package com.example.contactlist.feature_contact.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey val id : Int? = null,
    val name: String,
    val content: String,
    val image: Int,
    val timestamp: Long
)


class InvalidContactExeption(message: String): Exception(message)