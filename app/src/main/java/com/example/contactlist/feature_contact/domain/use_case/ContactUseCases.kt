package com.example.contactlist.feature_contact.domain.use_case

data class ContactUseCases(
    val addContact: AddContact,
    val deleteContact: DeleteContactUseCase,
    val getContactUseCase: GetContactUseCase,
    val getContactsUseCase: GetContactsUseCase
)