package com.coolme.me.twitterclientside.uiLayer.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.twitterclientside.uiLayer.component.ButtonSho
import com.coolme.me.twitterclientside.uiLayer.component.EditableTextSho
import com.coolme.me.twitterclientside.uiLayer.component.SnackbarHostSho
import com.coolme.me.twitterclientside.uiLayer.theme.PaddingColumn
import com.coolme.me.twitterclientside.uiLayer.theme.SpaceColumnHeight
import com.coolme.me.twitterclientside.uiLayer.theme.StyleTextSho2
import com.coolme.me.twitterclientside.uiLayer.widget.CircleProgressIndicator

//@Preview(showBackground = true)
//@Composable
//fun Test()
//{
//    Text(text = "Hello")
//}

//@Preview()
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun PreviewSho()
//{
//    val keyboardController = LocalSoftwareKeyboardController.current
//    Profile(
//        keyboardController = keyboardController,
//        vM = hiltViewModel<ProfileVM>(),
//        navController = rememberNavController(),
//        scaffoldState = rememberScaffoldState(),
//
//           )
//}

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
    vM: ProfileVM = hiltViewModel(),
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
                Row()
                {
                    //var focus by remember { mutableStateOf(false) }
                    Text(
                        text = "Username:   ",
                        style = StyleTextSho2,
                        )
                    EditableTextSho(
                        text = vM.userPhone?.nickname!!,
                        editMode = vM.uiState.editMode,
                                   )
//                    if (!vM.uiState.editMode)
//                    {
//                        Text(
//                            modifier = Modifier.clickable {
//                                vM.onEditModeChange(true)
//                            },
//                            text = vM.userPhone?.nickname!!,
//                            style = StyleTextSho,
//                            )
//                    }
//                    else
//                    {
//                        TextFieldSho(
//                            modifier = Modifier.onFocusChanged {
//                                if (focus != it.isFocused) {
//                                    focus = it.isFocused
//                                    if (!it.isFocused) {
//                                        vM.onEditModeChange(false)
//                                    }
//                                }
//                            }
//
//                            ,
//                            value = vM.userPhone?.nickname!!,
//                            onValueChange = {vM.onNicknameChange(it)},
//                            label = "nickname",
//                                    )
//                    }
                }

//                Row()
//                {
//                    var focus by remember { mutableStateOf(true) }
//                    Text(
//                        text = "Username:   ",
//                        style = StyleTextSho2,
//                        )
//                    TextFieldSho(
//                        modifier = Modifier
//                            .onFocusChanged {
//                                println(it.isFocused)
//                            focus = !it.isFocused
//                        }
//                        ,
//                        readOnly = focus,
//                        value = vM.userPhone?.nickname!!,
//                        onValueChange = {vM.onNicknameChange(it)},
//                        label = "nickname",
//                                )
//
//                }


                ButtonSho(
                    onClick = {
                        keyboardController?.hide()

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