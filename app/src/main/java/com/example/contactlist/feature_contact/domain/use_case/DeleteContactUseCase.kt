package com.example.contactlist.feature_contact.domain.use_case

import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.domain.repository.ContactRepository

class DeleteContactUseCase(
    private val repo: ContactRepository
) {

    suspend operator fun invoke(contact: Contact) {
        repo.deleteContact(contact)
    }
}