package com.example.contactlist.feature_contact.repository

import com.example.contactlist.feature_contact.data_source.ContactDao
import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(
    private val contactDao: ContactDao
): ContactRepository {
    override fun getContacts(): Flow<List<Contact>> {
        return contactDao.getContacts()
    }

    override suspend fun getContactById(id: Int): Contact? {
        return contactDao.getContactById(id)
    }

    override suspend fun insertContact(contact: Contact) {
         contactDao.insertContact(contact)
    }

    override suspend fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}