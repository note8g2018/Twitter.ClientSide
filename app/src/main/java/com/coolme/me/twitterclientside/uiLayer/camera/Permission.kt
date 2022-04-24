package com.coolme.me.twitterclientside.uiLayer.camera

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun FeatureThatRequiresCameraPermission() {

    // Camera permission state
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
                                                       )

    when (cameraPermissionState.status) {
        // If the camera permission is granted, then show screen with the feature enabled
        PermissionStatus.Granted -> {
            Text("Camera permission Granted")
        }
        is PermissionStatus.Denied -> {
            Column {
                val textToShow = if (cameraPermissionState.status.shouldShowRationale) {
                    // If the user has denied the permission but the rationale can be shown,
                    // then gently explain why the app requires this permission
                    "The camera is important for this app. Please grant the permission."
                } else {
                    // If it's the first time the user lands on this feature, or the user
                    // doesn't want to be asked again for this permission, explain that the
                    // permission is required
                    "Camera permission required for this feature to be available. " +
                            "Please grant the permission"
                }
                Text(textToShow)
                Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                    Text("Request permission")
                }
            }
        }
    }
}

@SuppressLint("PermissionLaunchedDuringComposition")
@ExperimentalPermissionsApi
@Composable
fun Permission(
    permission: String = Manifest.permission.CAMERA,
    rationale: String = "This permission is important for this app. Please grant the permission.",
    permissionNotAvailableContent: @Composable () -> Unit = { },
    content: @Composable () -> Unit = { }
              )
{
    val permissionState = rememberPermissionState(permission)
    
    when(permissionState.status)
    {
        is PermissionStatus.Granted -> content()
        is PermissionStatus.Denied ->
        {
            Column(modifier = Modifier.fillMaxSize()) 
            {
                Button(
                    onClick = { permissionState.launchPermissionRequest() }
                      ) 
                {
                    Text("Request permission")
                }
                
                Text(text = rationale)
                
                permissionNotAvailableContent()
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun Rationale(
    text: String,
    //onRequestPermission: () -> Unit,
    permissionState: PermissionState,
                     )
{
    AlertDialog(
        onDismissRequest = { /* Don't */ },
        title = {
            Text(text = "Permission request")
        },
        text = {
            Text(text)
        },
        confirmButton = {
            Button(onClick = { permissionState.launchPermissionRequest() })
            {
                Text("Ok")
            }
        }
               )
}