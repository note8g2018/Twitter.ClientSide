package com.coolme.me.twitterclientside.uiLayer.camera2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.FlipCameraAndroid
import androidx.compose.material.icons.sharp.Lens
import androidx.compose.material.icons.sharp.PhotoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.coolme.me.twitterclientside.R

//@Composable
//fun CameraControls(cameraUIAction: (CameraUIAction) -> Unit) {
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Black)
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//       ) {
//
//        CameraControl(
//            Icons.Sharp.FlipCameraAndroid,
//            R.string.icn_camera_view_switch_camera_content_description,
//            modifier= Modifier.size(64.dp),
//            onClick = { cameraUIAction(CameraUIAction.OnSwitchCameraClick) }
//                     )
//
//        CameraControl(
//            Icons.Sharp.Lens,
//            R.string.icn_camera_view_camera_shutter_content_description,
//            modifier= Modifier
//                .size(64.dp)
//                .padding(1.dp)
//                .border(1.dp, Color.White, CircleShape),
//            onClick = { cameraUIAction(CameraUIAction.OnCameraClick) }
//                     )
//
//        CameraControl(
//            Icons.Sharp.PhotoLibrary,
//            R.string.icn_camera_view_view_gallery_content_description,
//            modifier= Modifier.size(64.dp),
//            onClick = { cameraUIAction(CameraUIAction.OnGalleryViewClick) }
//                     )
//
//    }
//}


@Composable
fun CameraControl(
    imageVector: ImageVector,
    contentDescId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
                 ) {


    IconButton(
        onClick = onClick,
        modifier = modifier
              ) {
        Icon(
            imageVector,
            contentDescription = stringResource(id = contentDescId),
            modifier = modifier,
            tint = Color.White
            )
    }

}