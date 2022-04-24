package com.coolme.me.twitterclientside.uiLayer.camera2

sealed class CameraUIAction
{
    object OnCameraClick : CameraUIAction()
    object OnGalleryViewClick : CameraUIAction()
    object OnSwitchCameraClick : CameraUIAction()
}
