package com.example.contactlist.feature_contact.presentation.add_edit_contact

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactlist.R
import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.domain.model.InvalidContactExeption
import com.example.contactlist.feature_contact.domain.use_case.ContactUseCases
import com.example.contactlist.feature_contact.presentation.ContactTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditContactViewModel @Inject constructor(
    private val contactUses: ContactUseCases,
): ViewModel() {

    private var currentContactId: Int? = null

    private val _contactName = mutableStateOf(ContactTextFieldState(
        hint = "Enter name"
    ))
    val contactName: State<ContactTextFieldState> = _contactName

    private val _contactDescription = mutableStateOf(ContactTextFieldState(
        hint = "Enter description"
    ))
    val contactDescription: State<ContactTextFieldState> = _contactDescription

    private val _contactMobileNumber = mutableStateOf(ContactTextFieldState(
        hint = "Enter mobile number"
    ))
    val contactMobileNumber: State<ContactTextFieldState> = _contactMobileNumber

    fun onEvent(event: AddEditContactEvent) {
        when(event) {
            is AddEditContactEvent.EnteredName -> {
                _contactName.value = contactName.value.copy(
                    text = event.name
                )
            }
            is AddEditContactEvent.EnteredDescription -> {
                _contactDescription.value = contactDescription.value.copy(
                    text = event.description
                )
            }
            is AddEditContactEvent.EnterMobileNumber -> {
                _contactMobileNumber.value = contactMobileNumber.value.copy(
                    text = event.mobileNumber
                )
            }
            AddEditContactEvent.SaveContent -> {
                viewModelScope.launch {
                    try{
                        viewModelScope.launch {
                            contactUses.addContact(
                                Contact(
                                    id = currentContactId,
                                    name =  contactName.value.text,
                                    content = contactDescription.value.text,
                                    image = R.drawable.ic_launcher_background,
                                    mobileNumber = contactMobileNumber.value.text,
                                    timestamp = System.currentTimeMillis()
                                )
                            )
                        }
                    } catch (e: InvalidContactExeption) {
                        throw InvalidContactExeption("Error test")
                    }
                }
            }
        }
    }
}