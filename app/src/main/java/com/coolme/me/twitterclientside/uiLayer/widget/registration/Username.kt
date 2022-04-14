package com.coolme.me.twitterclientside.uiLayer.widget.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationVM
import com.coolme.me.twitterclientside.uiLayer.component.ErrorText
import com.coolme.me.twitterclientside.uiLayer.component.RightButton
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldSho
import com.coolme.me.twitterclientside.uiLayer.modifierExtention.shadowWithColor
import com.coolme.me.twitterclientside.uiLayer.theme.*

@Composable
fun Username(
    registrationVM: RegistrationVM,
    xOffset: Dp,
    onUsernameNext: () -> Unit,
            )
{
    Username(
        username = registrationVM.uiState.username,
        onUsernameChange = {registrationVM.onUsernameChange(newUsername = it)},
        hasError= registrationVM.uiState.usernameHasError,
        xOffset = xOffset,
        onNext = { onClickNext(registrationVM,onUsernameNext) },
            )
}

@Composable
fun Username(
    username: String,
    onUsernameChange: (String) -> Unit,
    hasError: Boolean = false,
    xOffset: Dp,
    onNext: () -> Unit,
            )
{
    Box(
        modifier = Modifier
            .offset(
                x = xOffset,
                y = 0.dp
                   )
            .padding(PaddingAll)
            .fillMaxWidth()
            .shadowWithColor(
                color = TopBarContent,
                shadowRadius = ShadowRadius,
                            )
            .background(color = BoxBackground)
       )
    {
        Column(
            modifier = Modifier
                .padding(PaddingColumn)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(space = SpaceColumnHeight),
              )
        {
            TextFieldSho(
                value = username,
                onValueChange = onUsernameChange,
                label = "Username" ,
                icon = Icons.Filled.Create,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {onNext()},
                                                 )
                        )
            ErrorText(hasError = hasError, errorMessage = "This is NOT valid Username" )
            UsernameRule()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
               )
            {
                RightButton(onNext = onNext)
            }
        }
    }
}


//*****************************************

private fun onClickNext(
    registrationVM: RegistrationVM,
    onUsernameNext: () -> Unit
                       )
{
    registrationVM.validateUsername()
    if (!registrationVM.uiState.usernameHasError)
    {
        onUsernameNext()
    }
}

//*****************************************

