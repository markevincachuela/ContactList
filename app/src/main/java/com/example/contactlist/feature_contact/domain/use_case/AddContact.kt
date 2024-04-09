package com.example.contactlist.feature_contact.domain.use_case

import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.domain.model.InvalidContactExeption
import com.example.contactlist.feature_contact.domain.repository.ContactRepository
import kotlin.jvm.Throws

class AddContact(
    private val repo: ContactRepository
) {

    @Throws(InvalidContactExeption::class)
    suspend operator fun invoke(contact: Contact) {
        if (contact.name.isBlank()) {
            throw InvalidContactExeption("The name can't be empty")
        }
        repo.insertContact(contact)
    }
}