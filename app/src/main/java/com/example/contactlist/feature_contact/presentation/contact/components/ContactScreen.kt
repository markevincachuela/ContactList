@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
package com.example.contactlist.feature_contact.presentation.contact.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import kotlinx.coroutines.delay

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

        Box{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                SearchBarScreen(modifier = Modifier)

                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )

                Divider(color = Color.Black)

                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(
                        items = state.contacts,
                        key = { it.id!! }
                    ) { contact ->
                        SwipeToDelete(
                            item = contact,
                            onDelete = { viewModel.onDelete(contact) }
                        ) { contacts ->
                            ContactItem(
                                contact = contacts,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
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

@Composable
fun <T> SwipeToDelete(
    item: T,
    onDelete: (T) -> Unit,
    animationDuration: Int = 500,
    content: @Composable (T) -> Unit

) {
    var isRemoved by remember {
        mutableStateOf(false)
    }

    val state = rememberDismissState(
        confirmValueChange = { value ->
            if (value == DismissValue.DismissedToStart) {
                isRemoved = true
                true
            } else {
                false
            }
        }
    )

    LaunchedEffect(key1 = isRemoved) {
        if (isRemoved) {
            delay(animationDuration.toLong())
            onDelete(item)
            isRemoved = false
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(
            state = state,
            background = {
                DeleteBackground(swipeDismissState = state)
            },
            dismissContent = { content(item) },
            directions = setOf(DismissDirection.EndToStart)
        )
    }
}

@Composable
fun DeleteBackground(
    swipeDismissState: DismissState
) {
    val color = if (swipeDismissState.dismissDirection == DismissDirection.EndToStart) {
        Color.Red
    } else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.White
        )
    }
}