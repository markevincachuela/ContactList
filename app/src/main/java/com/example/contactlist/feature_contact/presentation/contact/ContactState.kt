package com.example.contactlist.feature_contact.presentation.contact

import com.example.contactlist.feature_contact.domain.model.Contact

data class ContactState(
    val contact: List<Contact> = emptyList()
)