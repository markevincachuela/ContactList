package com.example.contactlist.presentation.contact.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContractScreen(

) {
    val scaffoldState = remember { SnackbarHostState() }

    Scaffold(
       floatingActionButton = {
           FloatingActionButton(onClick = {

           }) {
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "Add Contact"
               )

           }
       },
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }
    ) {

    }

}