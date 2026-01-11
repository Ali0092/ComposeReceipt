package com.example.workshop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {


        Text( modifier = Modifier.padding(top = 50.dp),
            text = "Receipt Component", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        Receipt(
            backgroundColor = backgroundColor,
            dashesColor = Color(0xFF232323),
            contentColor = Color(0xFF131313),
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
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    sectionData = sectionData
                )
            },
            totalSectionContent = { receiptSectionData ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = receiptSectionData.label.toString(), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground)
                    Text(text = receiptSectionData.value.toString(), color = MaterialTheme.colorScheme.onBackground)
                }
            },
            footerSectionContent = { receiptSectionData ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp), verticalArrangement = Arrangement.Center
                ) {
                    Text(text = receiptSectionData.label.toString(), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = receiptSectionData.value.toString(), color = MaterialTheme.colorScheme.onBackground)
                }
            }
        )

        Text(text = "Receipt 1", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Inward,
            sectionData =  ZapSectionData(
                title = "Contact Details", items = listOf(
                    ReceiptSectionData(label = "Name", value = "Tim"),
                    ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                    ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                )
            ),
            backgroundColor = backgroundColor,
            contentColor = Color(0xFF131313),
        )

        Text(text = "Receipt 2", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Rounded,
            sectionData =  ZapSectionData(
                title = "Contact Details", items = listOf(
                    ReceiptSectionData(label = "Name", value = "Tim"),
                    ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                    ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                )
            ),
            backgroundColor = backgroundColor,
            contentColor = Color(0xFF131313),
        )


        Text(text = "Receipt 3", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Flat,
            sectionData =  ZapSectionData(
                title = "Contact Details", items = listOf(
                    ReceiptSectionData(label = "Name", value = "Tim"),
                    ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                    ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                )
            ),
            backgroundColor = backgroundColor,
            contentColor = Color(0xFF131313),
        )

        Text(text = "Receipt with Custom content style", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

        ReceiptTicketCustomComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {
                Box(modifier = Modifier.fillMaxWidth().height(150.dp), contentAlignment = Alignment.Center) {
                    Text(text = "Custom Receipt\nComponent", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center))

                }
            }
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

    }

}