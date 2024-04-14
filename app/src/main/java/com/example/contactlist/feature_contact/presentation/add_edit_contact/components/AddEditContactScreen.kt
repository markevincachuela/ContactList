package com.example.contactlist.feature_contact.presentation.add_edit_contact.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DriveFileRenameOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.contactlist.R
import com.example.contactlist.di.AnimatedUtils
import com.example.contactlist.feature_contact.domain.model.Contact
import com.example.contactlist.feature_contact.presentation.add_edit_contact.AddEditContactViewModel
import com.example.contactlist.ui.theme.PurpleGrey80


@Composable
fun BoxScope.AddEditContactScreen(
    animatedUtils: AnimatedUtils,
    viewModel : AddEditContactViewModel
) {
    val duration = 1000
    val intOffsetTweenSpec: TweenSpec<IntOffset> = tween(durationMillis = duration)



    val density = LocalDensity.current
    var filledName by remember {
        mutableStateOf("")
    }

    var filledContent by remember {
        mutableStateOf("")
    }

    var filledMobileNumber by remember {
        mutableStateOf("")
    }
    AnimatedVisibility(
        visible = animatedUtils.isAnimated.value,
        enter = slideInVertically(
            initialOffsetY = { with(density) { 350.dp.roundToPx() } },
            animationSpec = intOffsetTweenSpec,
        ), exit = slideOutVertically(
            targetOffsetY = { with(density) { 350.dp.roundToPx() } },
            animationSpec = intOffsetTweenSpec,
        ),
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(5.dp)
            .padding(bottom = 100.dp)
            .height(250.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(PurpleGrey80)
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
                        .border(2.dp, Color.Gray, CircleShape),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Display Picture",
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextField(
                        value = filledName,
                        onValueChange = { filledName = it },
                        label = {
                            Text(text = "Name")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.AccountBox,
                                contentDescription = "Mobile Number"
                            )
                        }
                    )

                    TextField(
                        value = filledContent,
                        onValueChange = { filledContent = it },
                        label = {
                            Text(text = "Content")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.DriveFileRenameOutline,
                                contentDescription = "Content"
                            )
                        }
                    )

                    TextField(
                        value = filledMobileNumber,
                        onValueChange = { filledMobileNumber = it },
                        label = {
                            Text(text = "Mobile Number")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Phone,
                                contentDescription = "Mobile Number"
                            )
                        }
                    )

                    Button(
                        onClick = {
                            animatedUtils.isAnimated.value = false
                            viewModel.insertContact(
                                contact = Contact(
                                    name = filledName,
                                    content = filledContent,
                                    image = R.drawable.ic_launcher_background,
                                    mobileNumber = filledMobileNumber,
                                    timestamp = System.currentTimeMillis())
                            )

                        }
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}

fun clearInputField() {

}