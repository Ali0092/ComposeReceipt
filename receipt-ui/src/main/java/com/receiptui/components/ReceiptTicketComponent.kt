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
 *
 * @param modifier Modifier to be applied to the component
 * @param padding Inner padding for the content
 * @param sectionData Receipt section data to display
 * @param topEdgeStyle Style of the top edge (Inward, Rounded, or Flat)
 * @param roundedCornerRadius Radius for rounded corners when using Rounded style
 * @param inwardCornerRadius Radius for inward curves when using Inward style
 * @param backgroundColor Background color of the ticket
 * @param contentColor Color for the text content
 * @param shadowElevation Elevation for the shadow effect (0.dp for no shadow)
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
    contentColor: Color,
    shadowElevation: Dp = 0.dp
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
        color = backgroundColor,
        shadowElevation = shadowElevation
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
    shadowElevation: Dp = 0.dp,
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
        color = backgroundColor,
        shadowElevation = shadowElevation
    ) {
        content()
    }
}

