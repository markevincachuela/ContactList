package com.example.contactlist.presentation.contact

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.contactlist.domain.use_case.ContactUseCases

class ContactViewModel(
    private val contactUseCases: ContactUseCases
) {

    private val _state = mutableStateOf(ContactState())
    val state: State<ContactState> = _state


}