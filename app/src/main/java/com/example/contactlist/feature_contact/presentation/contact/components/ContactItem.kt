package com.example.contactlist.feature_contact.presentation.contact.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.contactlist.feature_contact.domain.model.Contact

@Composable
fun ContactItem(
    contact: Contact,
    modifier: Modifier = Modifier,
    onClickDelete: () -> Unit
) {

    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(65.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = contact.image),
                contentDescription = "Display picture",
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly

            ) {
                Text(
                    text = contact.id.toString()
                )
                Text(
                    text = "name: ${contact.name}",
                    overflow = TextOverflow.Ellipsis

                )
                Text(
                    text = "description: ${contact.content}",
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "mobile number: ${contact.mobileNumber}",
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

    }
}