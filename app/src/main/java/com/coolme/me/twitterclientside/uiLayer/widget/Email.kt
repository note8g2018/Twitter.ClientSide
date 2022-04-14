package com.coolme.me.twitterclientside.uiLayer.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coolme.me.twitterclientside.uiLayer.screen.registration.RegistrationVM
import com.coolme.me.twitterclientside.uiLayer.component.ErrorText
import com.coolme.me.twitterclientside.uiLayer.component.LeftButton
import com.coolme.me.twitterclientside.uiLayer.component.RightButton
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldSho
import com.coolme.me.twitterclientside.uiLayer.modifierExtention.shadowWithColor
import com.coolme.me.twitterclientside.uiLayer.theme.*

@Composable
fun Email(
    registrationVM: RegistrationVM,
    xOffset: Dp,
    onEmailNext: () -> Unit,
    onBack: () -> Unit,
            )
{
    Email(
        email = registrationVM.uiState.email,
        onEmailChange = {registrationVM.onEmailChange(newEmail = it)},
        hasError= registrationVM.uiState.emailHasError,
        xOffset = xOffset,
        onNext = { onClickNext(registrationVM,onEmailNext) },
        onBack= onBack,
            )
}

@Composable
fun Email(
    email: String,
    onEmailChange: (String) -> Unit,
    hasError: Boolean = false,
    xOffset: Dp,
    onNext: () -> Unit,
    onBack: () -> Unit,
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
                value = email,
                onValueChange = onEmailChange,
                label = "Email" ,
                icon = Icons.Filled.Email,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {onNext()},
                                                 )
                        )
            ErrorText(hasError = hasError, errorMessage = "This is NOT valid Email" )
            Spacer(Modifier.height(SpaceHeight))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
               )
            {
                LeftButton(onBack = onBack)
                RightButton(onNext = onNext)
            }
        }
    }
}


//*****************************************

private fun onClickNext(
    registrationVM: RegistrationVM,
    onEmailNext: () -> Unit
                       )
{
    registrationVM.validateEmail()
    if (!registrationVM.uiState.emailHasError)
    {
        onEmailNext()
    }
}

//*****************************************