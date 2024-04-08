package com.example.contactlist.domain.model

data class Contact(
    val id : Int? = null,
    val name: String,
    val content: String,
    val image: Int,
    val timestamp: Long
)