package com.example.contactlist.feature_contact.presentation.contact.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.contactlist.R
import com.example.contactlist.di.AnimatedUtils
import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.presentation.add_edit_contact.AddEditContactViewModel
import com.example.contactlist.feature_contact.presentation.add_edit_contact.components.AddEditContactScreen
import com.example.contactlist.feature_contact.presentation.contact.ContactViewModel
import com.example.contactlist.feature_contact.presentation.searchbar.components.SearchBarScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContractScreen(
    viewModel: ContactViewModel = hiltViewModel()
) {
    val scaffoldState = remember { SnackbarHostState() }

    val state = viewModel.state.value

    val viewModels: AddEditContactViewModel = hiltViewModel()

    val animatedUtils = AnimatedUtils

    Scaffold(
       floatingActionButton = {
           FloatingActionButton(onClick = {
               animatedUtils.isAnimated.value = !animatedUtils.isAnimated.value
           }) {
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "Add Contact"
               )
           }
       },
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }
    ) {

        Box(
            modifier = Modifier.clickable {
                if (animatedUtils.isAnimated.value) {
                    animatedUtils.isAnimated.value = false
                }
            }
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                SearchBarScreen(modifier = Modifier)

                Spacer(modifier = Modifier
                    .height(15.dp)
                )

                HorizontalDivider(color = Color.Black)

                Spacer(modifier = Modifier
                    .height(30.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(state.contacts) { contact ->
                        ContactItem(
                            contact = contact,
                            modifier = Modifier,
                            onClickDelete = {

                            }
                        )
                    }
                }
            }
            AddEditContactScreen(
                animatedUtils = animatedUtils,
                viewModel = viewModels
            )
        }


    }

}