package com.coolme.me.twitterclientside.uiLayer.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Title
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.ButtonSho
import com.coolme.me.twitterclientside.uiLayer.component.ErrorText
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.component.TextFieldSho
import com.coolme.me.twitterclientside.uiLayer.screen.article.ArticleVM
import com.coolme.me.twitterclientside.uiLayer.theme.PaddingColumn
import com.coolme.me.twitterclientside.uiLayer.theme.SpaceColumnHeight
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Profile(
    navController: NavController,
        )
{
    val keyboardController = LocalSoftwareKeyboardController.current
    Profile(
        keyboardController = keyboardController,
        navController = navController,
        scaffoldState = rememberScaffoldState(),
        )
}

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Profile(
    keyboardController: SoftwareKeyboardController?,
    vM: ArticleVM = hiltViewModel(),
    navController: NavController,
    scaffoldState: ScaffoldState,
        )
{
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarProfile(navController = navController) },
            )
    {
        Box( modifier = Modifier
            .fillMaxSize()
            //.verticalScroll(rememberScrollState())
           )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingColumn),
                verticalArrangement = Arrangement.spacedBy(space = SpaceColumnHeight),
                  )
            {

                TextFieldSho(
                    value = vM.uiState.title,
                    onValueChange = {vM.onTitleChange(it)},
                    label = "Title",
                    icon = Icons.Filled.Title,
                            )
                ErrorText(hasError = vM.uiState.titleHasError,
                          errorMessage = "The title cannot be empty" )
                TextFieldSho(
                    modifier = Modifier.weight(weight = 1.0f, fill = true),
                    singleLine = false,
                    value = vM.uiState.body,
                    onValueChange = {vM.onBodyChange(it)},
                    label = "Body",
                    icon = Icons.Filled.Book,
                            )
                ErrorText(hasError = vM.uiState.bodyHasError,
                          errorMessage = "The body cannot be empty" )
                ButtonSho(
                    onClick = {
                        keyboardController?.hide()
                        vM.send(scaffoldState, navController)
                              },
                    text = "Send",
                         )
            }

            if(vM.uiState.progressing)
            {
                CircleProgressIndicator()
            }
        }
    }
}