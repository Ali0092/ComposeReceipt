package com.example.workshop

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import com.receiptui.components.Receipt
import com.receiptui.components.TicketSectionItem
import com.receiptui.modals.ReceiptData
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData

@Composable
fun ReceiptComponentScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {


        Receipt(
            modifier = Modifier
                .padding(horizontal = 16.dp),
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
                            ReceiptSectionData(label = "Status", value = "Pending")
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
    }

}