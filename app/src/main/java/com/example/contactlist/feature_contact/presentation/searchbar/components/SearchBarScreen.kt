package com.example.contactlist.feature_contact.presentation.searchbar.components

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchBarScreen(
    modifier : Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            imageVector = Icons.Default.List,
            contentDescription = "Contact list"
        )

        Text(
            text = "Contacts"
        )

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search"
        )
    }

}