package com.coolme.me.twitterclientside.uiLayer.camera2

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

//@Composable
//fun CameraView(
//    onImageCaptured: (Uri, Boolean) -> Unit,
//    onError: (ImageCaptureException) -> Unit
//              )
//{
//    val context = LocalContext.current
//    var lensFacing by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }
//    val imageCapture: ImageCapture = remember {
//        ImageCapture.Builder().build()
//    }
//    val galleryLauncher = rememberLauncherForActivityResult(
//        ActivityResultContracts.GetContent()
//                                                           ) { uri: Uri? ->
//        if (uri != null) onImageCaptured(uri, true)
//    }
//
//    CameraPreviewView(
//        imageCapture,
//        lensFacing
//                     ) { cameraUIAction ->
//        when (cameraUIAction) {
//            is CameraUIAction.OnCameraClick       -> {
//                imageCapture.takePicture(context, lensFacing, onImageCaptured, onError)
//            }
//            is CameraUIAction.OnSwitchCameraClick -> {
//                lensFacing =
//                    if (lensFacing == CameraSelector.LENS_FACING_BACK) CameraSelector.LENS_FACING_FRONT
//                    else
//                        CameraSelector.LENS_FACING_BACK
//            }
//            is CameraUIAction.OnGalleryViewClick  -> {
//                if (true == context.getOutputDirectory().listFiles()?.isNotEmpty()) {
//                    galleryLauncher.launch("image/*")
//                }
//            }
//        }
//    }
//}