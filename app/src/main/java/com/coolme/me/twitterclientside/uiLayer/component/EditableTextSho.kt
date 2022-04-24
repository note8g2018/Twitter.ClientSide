package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import com.coolme.me.twitterclientside.uiLayer.theme.StyleTextSho

@Composable
fun EditableTextSho(
    text: String = "",
    //onTextChange: (String) -> Unit,
    editMode: Boolean = false,
    //onClick: () -> Unit,
    //onFocusChanged: () -> Unit,
                   )
{
    var text by remember { mutableStateOf(text) }
    var editMode by remember { mutableStateOf(editMode) }

    EditableTextSho(
        text = text,
        onTextChange = { text = it },
        editMode = editMode,
        onClick = {editMode = true},
        onFocusChanged = {editMode = false},
                   )
}

@Composable
fun EditableTextSho(
    text: String = "",
    onTextChange: (String) -> Unit,
    editMode: Boolean = false,
    onClick: () -> Unit,
    onFocusChanged: () -> Unit,
                   )
{
    var focus by remember { mutableStateOf(false) }
    //var editMode by remember { mutableStateOf(editMode) }
    //var text by remember { mutableStateOf("") }

    if (!editMode)
    {
        Text(
            modifier = Modifier.clickable {
                onClick()
            },
            text = text,
            style = StyleTextSho,
            )
    }
    else
    {
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.onFocusChanged {
                if (focus != it.isFocused) {
                    focus = it.isFocused
                    if (!it.isFocused) {
                        onFocusChanged()
                    }
                }
            }
                 )

    }
}