package com.coolme.me.twitterclientside.uiLayer.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coolme.me.twitterclientside.uiLayer.theme.StyleSnackBarContentText
import com.coolme.me.twitterclientside.uiLayer.theme.StyleOutlinedButton

@Composable
fun SnackBarAction(
    snackbarData: SnackbarData,
    onClick: ()-> Unit,
                  )
{
    Box()
    {
        OutlinedButton(onClick = onClick)
        {
            Text(
                text = snackbarData.actionLabel?: "Hide",
                style = StyleOutlinedButton,
                )
        }
    }
}

@Composable
fun SnackBarContent(
    snackbarData: SnackbarData,
                   )
{
    Text(
        text = snackbarData.message,
        style = StyleSnackBarContentText,
        )
}

@Composable
fun SnackbarSho(
    snackbarData: SnackbarData,
               )
{
    SnackbarSho(
        action = {
            SnackBarAction(
                snackbarData= snackbarData,
                onClick = {snackbarData.dismiss()}
                          )
        },
        content = { SnackBarContent(snackbarData) },
        backgroundColor= Color.Red,
               )
}

@Composable
fun SnackbarSho(
    modifier: Modifier = Modifier,
    action: @Composable (() -> Unit)? = null,
    actionOnNewLine: Boolean = false,
    shape: Shape = MaterialTheme.shapes.small,
    backgroundColor: Color = SnackbarDefaults.backgroundColor,
    contentColor: Color = MaterialTheme.colors.surface,
    elevation: Dp = 6.dp,
    content: @Composable () -> Unit,
                )
{
        Snackbar(
            modifier = modifier,
            action = action,
            actionOnNewLine = actionOnNewLine,
            shape = shape,
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            elevation = elevation,
            content = content,
                )

}

@Composable
fun SnackbarHostSho(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
                )
{
    SnackbarHost(
        hostState = hostState,
        modifier = modifier
                ) {
        SnackbarSho(it)
    }
}

