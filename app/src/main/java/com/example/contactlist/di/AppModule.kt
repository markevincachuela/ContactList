package com.example.contactlist.di

import android.app.Application
import androidx.room.Room
import com.example.contactlist.feature_contact.data_source.ContactDatabase
import com.example.contactlist.feature_contact.domain.repository.ContactRepository
import com.example.contactlist.feature_contact.domain.use_case.AddContact
import com.example.contactlist.feature_contact.domain.use_case.ContactUseCases
import com.example.contactlist.feature_contact.domain.use_case.DeleteContactUseCase
import com.example.contactlist.feature_contact.domain.use_case.GetContactUseCase
import com.example.contactlist.feature_contact.domain.use_case.GetContactsUseCase
import com.example.contactlist.feature_contact.repository.ContactRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContactDatabase(app: Application): ContactDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = ContactDatabase::class.java,
            name = ContactDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideContactRepository(db: ContactDatabase): ContactRepository {
        return ContactRepositoryImpl(db.contactDao)
    }

    @Provides
    @Singleton
    fun provideContactUseCases(repo: ContactRepository): ContactUseCases {
        return ContactUseCases(
            addContact = AddContact(repo),
            deleteContact = DeleteContactUseCase(repo),
            getContactUseCase = GetContactUseCase(repo),
            getContactsUseCase = GetContactsUseCase(repo)
        )
    }

}