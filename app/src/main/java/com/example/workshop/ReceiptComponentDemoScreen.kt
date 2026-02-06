package com.example.workshop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.workshop.ui.theme.backgroundColor
import com.receiptui.components.Receipt
import com.receiptui.components.ReceiptFooterComponent
import com.receiptui.components.ReceiptTicketComponent
import com.receiptui.components.ReceiptTicketCustomComponent
import com.receiptui.components.SharpCorneredTicket
import com.receiptui.components.SharpCorneredTicketCustom
import com.receiptui.components.TicketSectionItem
import com.receiptui.modals.ReceiptData
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData
import com.receiptui.shapes.TopEdgeStyle

@Composable
fun ReceiptComponentDemoScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        Text( modifier = Modifier.padding(top = 30.dp),
            text = "Receipt Component", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        Receipt(
            dashesColor = Color(0xFFF5F4F4),
            backgroundColor = Color(0xFF2F2F2F),
            contentColor = Color(0xFFF5F4F4),
            shadowElevation = 10.dp,
            receiptData = ReceiptData(
                sectionsData = listOf(
                    ZapSectionData(
                        title = "Contact Details", items = listOf(
                            ReceiptSectionData(label = "Name", value = "Tim"),
                            ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                            ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                        )
                    ),
                    ZapSectionData(
                        title = "Transaction Details", items = listOf(
                            ReceiptSectionData(label = "ID", value = "#120304050-1"),
                            ReceiptSectionData(label = "Date", value = "12-Dec-2024"),
                            ReceiptSectionData(label = "Time", value = "12:30 PM"),
                        )
                    )
                ),
                totalSectionData = ReceiptSectionData(label = "Total", value = "3500 Rs"),
                descriptionSectionData = ReceiptSectionData(label = "Description", value = "Wholesale product Payment sent to Tim."),
            ),
            ticketSectionContent = { sectionData ->
                TicketSectionItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentColor = Color(0xFFF5F4F4),
                    sectionData = sectionData
                )
            },
            totalSectionContent = { receiptSectionData ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = receiptSectionData.label.toString(), style = MaterialTheme.typography.titleLarge, color = Color(0xFFF5F4F4))
                    Text(text = receiptSectionData.value.toString(), color = Color(0xFFF5F4F4))
                }
            },
            footerSectionContent = { receiptSectionData ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp), verticalArrangement = Arrangement.Center
                ) {
                    Text(text = receiptSectionData.label.toString(), style = MaterialTheme.typography.titleLarge, color = Color(0xFFF5F4F4))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = receiptSectionData.value.toString(), color = Color(0xFFF5F4F4))
                }
            },

        )

        Text(text = "Ticket Receipt (with shadow)", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Inward,
            sectionData =  ZapSectionData(
                title = "Contact Details", items = listOf(
                    ReceiptSectionData(label = "Name", value = "Tim"),
                    ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                    ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                )
            ),
            padding = PaddingValues(32.dp),
            inwardCornerRadius = 24.dp,
            backgroundColor = Color(0xff123123),
            contentColor = Color(0xFFF3F3F3),
            shadowElevation = 8.dp
        )

        Text(text = "Ticket with rounded top (elevated shadow)", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Rounded,
            sectionData =  ZapSectionData(
                title = "Contact Details", items = listOf(
                    ReceiptSectionData(label = "Name", value = "Tim"),
                    ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                    ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                )
            ),
            backgroundColor = Color(0xFF2F2F2F),
            contentColor = Color(0xFFF5F4F4),
            shadowElevation = 12.dp
        )


        Text(text = "Ticket with flat top", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Flat,
            sectionData =  ZapSectionData(
                title = "Contact Details", items = listOf(
                    ReceiptSectionData(label = "Name", value = "Tim"),
                    ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                    ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                )
            ),
            backgroundColor = Color(0xFF091F65),
            contentColor = Color(0xFFEAEAEA),
            shadowElevation = 8.dp
        )

        Text(text = "Receipt with Custom content style", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketCustomComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {
                Box(modifier = Modifier.fillMaxWidth().height(150.dp), contentAlignment = Alignment.Center) {
                    Text(text = "Custom Receipt\nComponent", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

                }
            },
            shadowElevation = 8.dp
        )

        Text(text = "Receipt Footer", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptFooterComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp), verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Description", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Wholesale product payment ", color = MaterialTheme.colorScheme.onBackground)
                }
            }
        )

        Text(text = "Receipt Footer (without content)", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptFooterComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {
            }
        )

        Text(
            text = "Sharp Cornered Ticket (Default with shadow)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicket(
            sectionData = ZapSectionData(
                title = "Ticket Info",
                items = listOf(
                    ReceiptSectionData(label = "Style", value = "Default"),
                    ReceiptSectionData(label = "Depth", value = "8dp"),
                    ReceiptSectionData(label = "Width", value = "16dp")
                )
            ),
            backgroundColor = backgroundColor,
            contentColor = Color(0xFF131313),
            shadowElevation = 10.dp,
            tonalElevation = 5.dp
        )

        Text(
            text = "Sharp Cornered Ticket (Asymmetric)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicket(
            sectionData = ZapSectionData(
                title = "Asymmetric Design",
                items = listOf(
                    ReceiptSectionData(label = "Top", value = "Small (6dp)"),
                    ReceiptSectionData(label = "Bottom", value = "Large (14dp)"),
                    ReceiptSectionData(label = "Status", value = "Active")
                )
            ),
            topZigzagDepth = 6.dp,
            topZigzagWidth = 12.dp,
            bottomZigzagDepth = 14.dp,
            bottomZigzagWidth = 28.dp,
            shadowElevation = 5.dp,
            tonalElevation = 5.dp,
            backgroundColor = Color(0xFF00BCD4),
            contentColor = Color(0xFF131313)
        )

        Text(
            text = "Sharp Cornered Ticket (Custom Content with shadow)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicketCustom(
            backgroundColor = Color(0xFFC97907),
            topZigzagDepth = 10.dp,
            topZigzagWidth = 20.dp,
            bottomZigzagDepth = 10.dp,
            bottomZigzagWidth = 20.dp,
            shadowElevation = 10.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Custom Layout",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "This demonstrates the custom content variant with full control over the internal layout.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

    }

}