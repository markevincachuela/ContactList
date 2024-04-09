package com.example.contactlist.feature_contact.presentation.add_edit_contact

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.domain.use_case.ContactUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditContactViewModel @Inject constructor(
    private val contactUses: ContactUseCases,
): ViewModel() {

    private var currentContactId: Int? = null

     fun insertContact(contact: Contact) {
        Log.d("KEEEVS","insertContact === $contact")
         viewModelScope.launch {
             contactUses.addContact(
                 Contact(
                     id = currentContactId,
                     name =  contact.name,
                     content = contact.content,
                     image = contact.image,
                     timestamp = System.currentTimeMillis()
                 )
             )
         }
    }
}