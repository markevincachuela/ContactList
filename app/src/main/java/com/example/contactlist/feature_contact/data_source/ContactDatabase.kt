package com.example.contactlist.feature_contact.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactlist.feature_contact.domain.model.Contact


@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactDatabase: RoomDatabase() {

    abstract val contactDao: ContactDao

    companion object {
        const val DATABASE_NAME = "contact_db"
    }
}