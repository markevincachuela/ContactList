package com.example.contactlist.feature_contact.presentation.add_edit_contact

sealed class AddEditContactEvent {
    data class EnteredName(val name: String) : AddEditContactEvent()
    data class EnteredContent(val content: String): AddEditContactEvent()
    object SaveContent: AddEditContactEvent()
}
