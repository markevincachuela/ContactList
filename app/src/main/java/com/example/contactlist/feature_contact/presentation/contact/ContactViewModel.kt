package com.example.contactlist.feature_contact.presentation.contact

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactlist.feature_contact.domain.use_case.ContactUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor (
    private val contactUseCases: ContactUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ContactState())
    val state: State<ContactState> = _state


    init {
        getContact()
    }
    fun getContact() {
        contactUseCases.getContactsUseCase()
            .onEach {contacts ->
                _state.value = state.value.copy(
                    contacts = contacts
                )
            }.launchIn(viewModelScope)
    }

}