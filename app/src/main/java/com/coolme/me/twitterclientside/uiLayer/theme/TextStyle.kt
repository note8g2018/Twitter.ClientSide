package com.coolme.me.twitterclientside.uiLayer.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

val StyleTopBar : TextStyle = TextStyle(
    fontSize = ContentBar,
    color = TopBarContent,
    fontFamily = aclonicaFamily,
    shadow = Shadow(
        offset= Offset(x= 0.0f, y=0.0f),
        blurRadius= 10.0f,
        color= TextShadow,
                   ),
                                       )

val StyleTextSho : TextStyle = TextStyle(
    color = UnfocusedBorderColor,
    fontSize = TextShoFontSize,
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Normal,
    fontFamily = chelaOneFamily,
    shadow = Shadow(
        offset= Offset(x= 0.0f, y=0.0f),
        blurRadius= 10.0f,
        color= Color.Black,
                   ),
                                       )

val StyleTextSho2 : TextStyle = TextStyle(
    color = TextShoColor,
    fontSize = ContentBar,
    fontWeight = FontWeight.Bold,
    fontStyle = FontStyle.Italic,
    fontFamily = ubuntuFamily,

//    shadow = Shadow(
//        offset= Offset(x= 0.0f, y=0.0f),
//        blurRadius= 10.0f,
//        color= TextShadow,
//                   ),
                                        )


val StyleInputText : TextStyle = TextStyle(
    fontSize = InputTextField,
    color = InputTextFiled,
                                          )

val StyleLabelText : TextStyle = TextStyle(
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
val StyleSnackBarContentText: TextStyle = TextStyle(
    fontSize = InputTextField,
                                                   )