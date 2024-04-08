package com.example.contactlist.presentation.contact

import com.example.contactlist.domain.model.Contact

data class ContactState(
    val contact: List<Contact> = emptyList()
)