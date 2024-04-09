package com.example.contactlist.feature_contact.domain.use_case

import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class GetContactsUseCase(
    private val repo: ContactRepository

) {

     operator fun invoke(): Flow<List<Contact>> {
         return repo.getContacts()
     }
}