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
import com.receiptui.shapes.SharpCorneredTicketShape

/**
 * A composable component that displays receipt section data in a sharp-cornered ticket shape
 * with zigzag edges on top and bottom.
 *
 * @param modifier Modifier to be applied to the component
 * @param padding Inner padding for the content
 * @param sectionData Receipt section data to display
 * @param topZigzagDepth Height of the triangular teeth on the top edge
 * @param topZigzagWidth Target width per tooth on the top edge
 * @param bottomZigzagDepth Height of the triangular teeth on the bottom edge
 * @param bottomZigzagWidth Target width per tooth on the bottom edge
 * @param backgroundColor Background color of the ticket
 * @param contentColor Color for the text content
 */
@Composable
fun SharpCorneredTicket(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(24.dp),
    sectionData: ZapSectionData<ReceiptSectionData>,
    topZigzagDepth: Dp = 8.dp,
    topZigzagWidth: Dp = 16.dp,
    bottomZigzagDepth: Dp = 8.dp,
    bottomZigzagWidth: Dp = 16.dp,
    backgroundColor: Color,
    contentColor: Color
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = SharpCorneredTicketShape(
            topZigzagDepth = topZigzagDepth,
            topZigzagWidth = topZigzagWidth,
            bottomZigzagDepth = bottomZigzagDepth,
            bottomZigzagWidth = bottomZigzagWidth
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

/**
 * A composable component that wraps custom content in a sharp-cornered ticket shape
 * with zigzag edges on top and bottom.
 *
 * @param modifier Modifier to be applied to the component
 * @param topZigzagDepth Height of the triangular teeth on the top edge
 * @param topZigzagWidth Target width per tooth on the top edge
 * @param bottomZigzagDepth Height of the triangular teeth on the bottom edge
 * @param bottomZigzagWidth Target width per tooth on the bottom edge
 * @param backgroundColor Background color of the ticket
 * @param content Custom composable content to display inside the ticket
 */
@Composable
fun SharpCorneredTicketCustom(
    modifier: Modifier = Modifier,
    topZigzagDepth: Dp = 8.dp,
    topZigzagWidth: Dp = 16.dp,
    bottomZigzagDepth: Dp = 8.dp,
    bottomZigzagWidth: Dp = 16.dp,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = SharpCorneredTicketShape(
            topZigzagDepth = topZigzagDepth,
            topZigzagWidth = topZigzagWidth,
            bottomZigzagDepth = bottomZigzagDepth,
            bottomZigzagWidth = bottomZigzagWidth
        ),
        color = backgroundColor
    ) {
        content()
    }
}
