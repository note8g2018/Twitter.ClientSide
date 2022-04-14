package com.coolme.me.twitterclientside.uiLayer.modifierExtention

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.NativePaint
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.shadowWithColor(
    color: Color = Color.Gray,
    alpha: Float = 0.9f,
    cornersRadius: Dp = 0.dp,
    shadowRadius: Dp = 15.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
                            ) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "shadowWithColor"
        properties["color"] = color
        properties["alpha"] = alpha
        properties["cornersRadius"] = cornersRadius
        properties["shadowRadius"] = shadowRadius
        properties["offsetX"] = offsetX
        properties["offsetY"] = offsetY
    },
    factory = {
        this.drawBehind(
            onDraw = {
                this.drawIntoCanvas(
                    block = {
                        val paint = Paint()
                        val frameWorkPaint : NativePaint = paint.asFrameworkPaint()
                        frameWorkPaint.color = color.copy(alpha= 0.0f).toArgb()
                        frameWorkPaint.setShadowLayer(
                            shadowRadius.toPx(),
                            offsetX.toPx(),
                            offsetY.toPx(),
                            color.copy(alpha = alpha).toArgb(),
                                                     )
                        it.drawRoundRect(
                            left = 0.0f,
                            top = 0.0f,
                            right = this.size.width,
                            bottom = this.size.height,
                            radiusX = cornersRadius.toPx(),
                            radiusY = cornersRadius.toPx(),
                            paint = paint,
                                        )
                    }
                                   )
            }
                       )
    }
                                        )