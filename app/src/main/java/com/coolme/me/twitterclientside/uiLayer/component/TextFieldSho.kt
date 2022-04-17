package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.coolme.me.twitterclientside.uiLayer.theme.StyleInputText
import com.coolme.me.twitterclientside.uiLayer.theme.StyleLabelText
import com.coolme.me.twitterclientside.uiLayer.theme.outlinedTextFieldColors

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldSho(
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    isError: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
                )
{
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (!it.isFocused) {
                    keyboardController?.hide()
                }
            },
        isError = isError,
        value = value,
        textStyle = StyleInputText,
        singleLine = singleLine,
        maxLines = maxLines,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = StyleLabelText,
                )
        },
        colors = outlinedTextFieldColors(),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                )
        },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = keyboardType,
            imeAction = imeAction,
                                         ),
        keyboardActions = keyboardActions,
                     )
}