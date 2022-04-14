package com.coolme.me.twitterclientside.uiLayer.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle

val TopBar : TextStyle = TextStyle(
    fontSize = ContentBar,
    color = TopBarContent,
    fontFamily = aclonicaFamily,
    shadow = Shadow(
        offset= Offset(x= 0.0f, y=0.0f),
        blurRadius= 10.0f,
        color= TextShadow,
                   ),
                                              )

val InputText : TextStyle = TextStyle(
    fontSize = InputTextField,
    color = InputTextFiled,
                                     )

val LabelText : TextStyle = TextStyle(
    fontSize = InputTextField,
                                     )

val StyleGreenButton : TextStyle = TextStyle(
    fontSize = InputTextField,
    color = OnGreenButton,
                                            )

val StyleError : TextStyle = TextStyle(
    fontSize = InputTextField,
    color = Error,
                                      )

val StyleRole : TextStyle = TextStyle(
    fontSize = InputTextField,
    color = UnfocusedBorderColor,
                                     )

val StyleOutlinedButton : TextStyle = TextStyle(
    fontSize = OutlinedButton,
                                               )
val SnackBarContentText: TextStyle = TextStyle(
    fontSize = InputTextField,
                               )