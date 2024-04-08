package com.example.contactlist.presentation.contact.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.contactlist.domain.model.Contact
import com.example.contactlist.presentation.contact.ContactState
import com.example.contactlist.presentation.searchbar.components.SearchBarScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContractScreen(

) {
    val scaffoldState = remember { SnackbarHostState() }

    val test: MutableList<Contact> = mutableListOf(
        Contact(1,"Kevs","test",2,4343),
        Contact(2,"Kevin","test1",3,123123),
        )

    Scaffold(
       floatingActionButton = {
           FloatingActionButton(onClick = {
               //Todo click for creating new contract
           }) {
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "Add Contact"
               )
           }
       },
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            SearchBarScreen(modifier = Modifier)

            Spacer(modifier = Modifier
                .height(15.dp)
            )

            Divider(color = Color.Black)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(test) {
                    Log.d("KEEEVS","teeest === $test")
                }

            }
        }

    }

}