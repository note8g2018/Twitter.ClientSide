package com.coolme.me.twitterclientside.uiLayer.theme

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable

@Composable
fun outlinedTextFieldColors() = TextFieldDefaults.outlinedTextFieldColors(
    unfocusedBorderColor = UnfocusedBorderColor,
    leadingIconColor = UnfocusedBorderColor,
    focusedBorderColor = TopBarContent,
    errorBorderColor = Error,
                                                                         )