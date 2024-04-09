package com.example.contactlist.feature_contact.presentation.contact

import com.example.contactlist.feature_contact.domain.model.Contact

data class ContactState(
    val contacts: List<Contact> = emptyList()
)