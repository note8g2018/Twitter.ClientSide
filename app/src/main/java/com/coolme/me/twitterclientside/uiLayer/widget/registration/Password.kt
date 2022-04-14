package com.coolme.me.twitterclientside.uiLayer.widget.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
fun Password(
    registrationVM: RegistrationVM,
    xOffset: Dp,
    onPasswordNext: () -> Unit,
    onBack: () -> Unit,
            )
{
    Password(
        password1 = registrationVM.uiState.password1,
        onPassword1Change = {registrationVM.onPassword1Change(newPassword = it)},
        password2 = registrationVM.uiState.password2,
        onPassword2Change = {registrationVM.onPassword2Change(newPassword = it)},
        hasError= registrationVM.uiState.passwordHasError,
        xOffset = xOffset,
        onNext = { onClickNext(registrationVM, onPasswordNext) },
        onBack = onBack,
            )
}

@Composable
fun Password(
    password1: String,
    onPassword1Change: (String) -> Unit,
    password2: String,
    onPassword2Change: (String) -> Unit,
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
                y = 0.dp,
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
                value = password1,
                onValueChange = onPassword1Change,
                label = "Password",
                icon = Icons.Filled.Password,
                visualTransformation = PasswordVisualTransformation(mask = '*'),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Send,
                keyboardActions = KeyboardActions(
                    onSend = {onNext()}
                                                 )
                        )

            ErrorText(errorMessage = "This is NOT valid Password", hasError = hasError)

            PasswordRule()

            TextFieldSho(
                value = password2,
                onValueChange = onPassword2Change,
                label = "Repeat Password",
                icon = Icons.Filled.Password,
                visualTransformation = PasswordVisualTransformation(mask = '*'),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Send,
                keyboardActions = KeyboardActions(
                    onSend = {onNext()},
                                                 )
                        )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
               )
            {
                LeftButton(
                    onBack = onBack,
                          )
                RightButton(
                    text = "Submit",
                    onNext = onNext,
                           )
            }
        }
    }
}


//*****************************************

private fun onClickNext(
    registrationVM: RegistrationVM,
    onPasswordNext: () -> Unit
                               )
{
    registrationVM.validatePassword()
    if (!registrationVM.uiState.passwordHasError)
    {
        onPasswordNext()
    }
}

//*****************************************