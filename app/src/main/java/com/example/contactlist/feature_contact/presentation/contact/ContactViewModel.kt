package com.example.contactlist.feature_contact.presentation.contact

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.contactlist.feature_contact.domain.use_case.ContactUseCases

class ContactViewModel(
    private val contactUseCases: ContactUseCases
) {

    private val _state = mutableStateOf(ContactState())
    val state: State<ContactState> = _state


}