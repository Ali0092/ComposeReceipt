package com.receiptui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiptui.shapes.ReceiptFooter


@Composable
fun ReceiptFooterComponent(
    modifier: Modifier = Modifier,
    roundedCornerRadius: Dp = 25.dp,
    inwardCornerRadius: Dp = 8.dp,
    scallopGap: Dp = 2.dp,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp),
        shape = ReceiptFooter(
            inwardCornerRadius = inwardCornerRadius,
            bottomCornerRadius = roundedCornerRadius,
            scalpGap = scallopGap
        ),
        color = backgroundColor
    ) {
        content()
    }
}
