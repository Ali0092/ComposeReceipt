package com.receiptui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiptui.modals.ReceiptData
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData
import com.receiptui.shapes.ReceiptFooter
import com.receiptui.shapes.TicketShape
import com.receiptui.shapes.TopEdgeStyle

/**
 * Comprehensive ticket-style receipt container with multiple sections, dashed dividers, and scalloped footer.
 * Displays transaction information in a structured format with customizable content lambdas for each section.
 *
 * @param receiptData Main data model containing all receipt content
 * @param backgroundColor Background color for ticket sections
 * @param dashesColor Color of dashed separator lines
 * @param contentColor Color of content including label, values and title lines
 * @param ticketSectionContent Lambda to render ticket section content
 * @param totalSectionContent Lambda to render total section content
 * @param footerSectionContent Lambda to render footer section content
 */
@Composable
fun Receipt(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color,
    dashesColor: Color,
    receiptData: ReceiptData,
    canShowSectionSeparator: Boolean = true,
    roundedCornerRadius: Dp = 25.dp,
    inwardCornerRadius: Dp = 8.dp,
    scallopGap: Dp = 2.dp,
    shadowElevation: Dp = 3.dp,
    tonalElevation: Dp = 3.dp,
    ticketSectionContent: @Composable (ZapSectionData<ReceiptSectionData>) -> Unit,
    totalSectionContent: @Composable (ReceiptSectionData) -> Unit,
    footerSectionContent: @Composable (ReceiptSectionData) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        if (!receiptData.sectionsData.isNullOrEmpty()) {
            repeat(receiptData.sectionsData.size) { index ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = TicketShape(
                        topEdgeStyle = if (index == 0) TopEdgeStyle.Rounded else TopEdgeStyle.Inward,
                        roundedCornerRadius = roundedCornerRadius,
                        inwardCornerRadius = inwardCornerRadius
                    ),
                    color = backgroundColor,
                    shadowElevation = shadowElevation,
                    tonalElevation = tonalElevation
                ) {
                    ticketSectionContent(receiptData.sectionsData[index])
                }
            }
        }

        if (canShowSectionSeparator) {
            DashedLine(
                modifier = Modifier.padding(horizontal = 8.dp),
                dashColor = dashesColor,
                gapColor = backgroundColor
            )
        }

        if (receiptData.totalSectionData != null) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = TicketShape(
                    roundedCornerRadius = roundedCornerRadius,
                    inwardCornerRadius = inwardCornerRadius
                ),
                color = backgroundColor,
                shadowElevation = shadowElevation,
                tonalElevation = tonalElevation
            ) {
                totalSectionContent(receiptData.totalSectionData)
            }

        }

        if (canShowSectionSeparator) {
            DashedLine(
                modifier = Modifier.padding(horizontal = 8.dp),
                dashColor = dashesColor,
                gapColor = backgroundColor
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .then(if (receiptData.descriptionSectionData != null) Modifier.wrapContentHeight() else Modifier.height(40.dp)),
            shape = ReceiptFooter(
                inwardCornerRadius = inwardCornerRadius,
                bottomCornerRadius = roundedCornerRadius,
                scalpGap = scallopGap
            ),
            color = backgroundColor,
            shadowElevation = shadowElevation,
            tonalElevation = tonalElevation
        ) {
            if (receiptData.descriptionSectionData != null) {
                footerSectionContent(receiptData.descriptionSectionData)
            }
        }
    }

}

/**
 * Renders a single receipt section with title and label-value rows.
 */
@Composable
fun TicketSectionItem(
    modifier: Modifier = Modifier,
    contentColor: Color,
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    labelStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    valueStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    sectionData: ZapSectionData<ReceiptSectionData>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
       Text(
            text = sectionData.title,
            style = titleStyle,
            color = contentColor
        )
        repeat(sectionData.items.size) { index ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = sectionData.items[index].label ?: "",
                    color = contentColor,
                    style = labelStyle
                )
                Text(
                    text = sectionData.items[index].value ?: "",
                    color = contentColor,
                    style = valueStyle
                )
            }
        }
    }
}