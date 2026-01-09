package com.receiptui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData
import com.receiptui.shapes.TicketShape
import com.receiptui.shapes.TopEdgeStyle

/**
 * A composable component that displays receipt section data in a ticket shape.
 */
@Composable
fun ReceiptTicketComponent(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(24.dp),
    sectionData: ZapSectionData<ReceiptSectionData>,
    topEdgeStyle: TopEdgeStyle = TopEdgeStyle.Inward,
    roundedCornerRadius: Dp = 25.dp,
    inwardCornerRadius: Dp = 16.dp,
    backgroundColor: Color,
    contentColor: Color
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = TicketShape(
            topEdgeStyle = topEdgeStyle,
            roundedCornerRadius = roundedCornerRadius,
            inwardCornerRadius = inwardCornerRadius
        ),
        color = backgroundColor
    ) {
        TicketSectionItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            contentColor = contentColor,
            sectionData = sectionData
        )
    }
}




@Composable
fun ReceiptTicketCustomComponent(
    modifier: Modifier = Modifier,
    topEdgeStyle: TopEdgeStyle = TopEdgeStyle.Inward,
    roundedCornerRadius: Dp = 25.dp,
    inwardCornerRadius: Dp = 8.dp,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = TicketShape(
            topEdgeStyle = topEdgeStyle,
            roundedCornerRadius = roundedCornerRadius,
            inwardCornerRadius = inwardCornerRadius
        ),
        color = backgroundColor
    ) {
        content()
    }
}

