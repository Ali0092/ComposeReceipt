package com.receiptui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    dashColor: Color = Color.Gray,
    gapColor: Color = Color.White,
    dashWidth: Dp = 12.dp,
    dashGap: Dp = 8.dp,
    strokeWidth: Dp = 1.dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(strokeWidth)
            .background(gapColor),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(strokeWidth)
        ) {
            // Draw the background rectangle (gap color)
            drawRect(
                color = gapColor,
                topLeft = Offset(0f, 0f),
                size = Size(size.width, size.height)
            )

            // Draw the dashed line on top
            val pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashWidth.toPx(), dashGap.toPx()),
                phase = 0f
            )

            drawLine(
                color = dashColor,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                strokeWidth = strokeWidth.toPx(),
                pathEffect = pathEffect,
                cap = StrokeCap.Butt
            )
        }
    }
}
