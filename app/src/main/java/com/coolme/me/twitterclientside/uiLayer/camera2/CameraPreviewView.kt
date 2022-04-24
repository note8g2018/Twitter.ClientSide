package com.coolme.me.twitterclientside.uiLayer.camera2

//@SuppressLint("RestrictedApi")
//@Composable
//fun CameraPreviewView(
//    imageCapture: ImageCapture,
//    lensFacing: Int = CameraSelector.LENS_FACING_BACK,
//    cameraUIAction: (CameraUIAction) -> Unit
//                             ) {
//
//    val context = LocalContext.current
//    val lifecycleOwner = LocalLifecycleOwner.current
//
//    val preview = Preview
//        .Builder().build()
//    val cameraSelector = CameraSelector.Builder()
//        .requireLensFacing(lensFacing)
//        .build()
//
//    val previewView = remember { PreviewView(context) }
//    LaunchedEffect(lensFacing) {
//        val cameraProvider = context.getCameraProvider()
//        cameraProvider.unbindAll()
//        cameraProvider.bindToLifecycle(
//            lifecycleOwner,
//            cameraSelector,
//            preview,
//            imageCapture
//                                      )
//        preview.setSurfaceProvider(previewView.surfaceProvider)
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        AndroidView({ previewView }, modifier = Modifier.fillMaxSize()) {
//
//        }
//        Column(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            verticalArrangement = Arrangement.Bottom
//              ) {
//            CameraControls(cameraUIAction)
//        }
//
//    }
//}


//******************************************************************

//suspend fun Context.getCameraProvider(): ProcessCameraProvider =
//    suspendCoroutine { continuation ->
//    ProcessCameraProvider.getInstance(this).also { cameraProvider ->
//        cameraProvider.addListener({
//                                       continuation.resume(cameraProvider.get())
//                                   }, ContextCompat.getMainExecutor(this))
//    }
//}
