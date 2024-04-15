package com.example.contactlist.feature_contact.presentation.add_edit_contact

sealed class AddEditContactEvent {
    data class EnteredName(val name: String) : AddEditContactEvent()
    data class EnteredDescription(val description: String): AddEditContactEvent()
    data class EnterMobileNumber(val mobileNumber: String): AddEditContactEvent()
    object SaveContent: AddEditContactEvent()
}
