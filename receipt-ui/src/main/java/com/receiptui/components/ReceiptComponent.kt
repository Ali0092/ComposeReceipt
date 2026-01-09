package com.receiptui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.receiptui.modals.ReceiptData
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData
import com.receiptui.shapes.ReceiptFooter
import com.receiptui.shapes.TicketShape
import com.receiptui.shapes.TopEdgeStyle


@Preview(showBackground = true)
@Composable
fun TempPreview() {
    Receipt(
        modifier = Modifier.padding(horizontal = 16.dp),
        receiptData = ReceiptData(
            sectionsData = listOf(
                ZapSectionData(
                    title = "Contact Details", items = listOf(
                        ReceiptSectionData(label = "Name", value = "Tim"),
                        ReceiptSectionData(label = "Bank Name", value = "Payzap Bank"),
                        ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                    )
                ),
                ZapSectionData(
                    title = "Contact Details", items = listOf(
                        ReceiptSectionData(label = "Name", value = "Tim"),
                        ReceiptSectionData(label = "Bank Name", value = "Payzap Bank"),
                        ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                    )
                ),
                ZapSectionData(
                    title = "Contact Details", items = listOf(
                        ReceiptSectionData(label = "Name", value = "Tim"),
                        ReceiptSectionData(label = "Bank Name", value = "Payzap Bank"),
                        ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                    )
                )
            ),
            totalSectionData = ReceiptSectionData(label = "Total", value = "3500 Rs"),
            descriptionSectionData = ReceiptSectionData(label = "Description", value = "Wholesale product Payment sent to Tim."),
        ),
        ticketSectionContent = {
            TicketSectionItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                sectionData = it
            )
        },
        totalSectionContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = it.label.toString(), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground)
                Text(text = it.value.toString(), color = MaterialTheme.colorScheme.onBackground)
            }
        },
        footerSectionContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp), verticalArrangement = Arrangement.Center
            ) {
                Text(text = it.label.toString(), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.value.toString(), color = MaterialTheme.colorScheme.onBackground)
            }
        }
    )
}

/**
 * Comprehensive ticket-style receipt container with multiple sections, dashed dividers, and scalloped footer.
 * Displays transaction information in a structured format with customizable content lambdas for each section.
 *
 * @param receiptData Main data model containing all receipt content
 * @param ticketBackgroundColor Background color for ticket sections
 * @param dashesColor Color of dashed separator lines
 * @param ticketSectionContent Lambda to render ticket section content
 * @param totalSectionContent Lambda to render total section content
 * @param footerSectionContent Lambda to render footer section content
 */
@Composable
fun Receipt(
    modifier: Modifier = Modifier,
    ticketBackgroundColor: Color = Color(0xff123123),
    dashesColor: Color = Color(0xff123123),
    receiptData: ReceiptData,
    canShowSectionSeparator: Boolean = true,
    roundedCornerRadius: Dp = 25.dp,
    inwardCornerRadius: Dp = 8.dp,
    scallopDepth: Dp = 19.dp,
    scallopWidth: Dp = 27.dp,
    scallopGap: Dp = 2.dp,
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
                        inwardCornerRadius = inwardCornerRadius,
                        scallopDepth = scallopDepth,
                        scallopWidth = scallopWidth
                    ),
                    color = ticketBackgroundColor
                ) {
                    ticketSectionContent(receiptData.sectionsData[index])
                }
            }
        }

        if (canShowSectionSeparator) {
            DashedLine(
                modifier = Modifier.padding(horizontal = 8.dp),
                dashColor = dashesColor,
                gapColor = ticketBackgroundColor
            )
        }

        if (receiptData.totalSectionData != null) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = TicketShape(
                    roundedCornerRadius = roundedCornerRadius,
                    inwardCornerRadius = inwardCornerRadius,
                    scallopDepth = scallopDepth,
                    scallopWidth = scallopWidth
                ),
                color = ticketBackgroundColor
            ) {
                totalSectionContent(receiptData.totalSectionData)
            }

        }

        if (canShowSectionSeparator) {
            DashedLine(
                modifier = Modifier.padding(horizontal = 8.dp),
                dashColor = dashesColor,
                gapColor = ticketBackgroundColor
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
            color = ticketBackgroundColor
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
fun TicketSectionItem(modifier: Modifier = Modifier, sectionData: ZapSectionData<ReceiptSectionData>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
       Text(
            text = sectionData.title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        repeat(sectionData.items.size) { index ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = sectionData.items[index].label ?: "",
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = sectionData.items[index].value ?: "",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}