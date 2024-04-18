package com.example.contactlist.feature_contact.presentation.add_edit_contact

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle

@Composable
fun HintTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    contentDescription: String,
    imageVector: ImageVector,
    textStyle: TextStyle = TextStyle(),
    onValueChange: (String) -> Unit,

    ) {
    Box(
        modifier = modifier
    ) {
        TextField(
            value = text,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label
                )
            },
            textStyle = textStyle,
            leadingIcon = {
                Icon(
                    imageVector = imageVector,
                    contentDescription = contentDescription
                )
            }
        )
    }
}