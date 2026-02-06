package com.example.workshop.demos

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workshop.ui.theme.WorkshopTheme
import com.receiptui.components.Receipt
import com.receiptui.components.TicketSectionItem
import com.receiptui.modals.ReceiptData
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData

/**
 * Demo screen showcasing the full Receipt component with multiple sections,
 * dashed dividers, and scalloped footer.
 */
@Composable
fun ReceiptDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            text = "Receipt Component Demo",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center)
        )

        // Example 1: Dark themed receipt
        Text(
            text = "Dark Theme Receipt",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        Receipt(
            dashesColor = Color(0xFFF5F4F4),
            backgroundColor = Color(0xFF2F2F2F),
            contentColor = Color(0xFFF5F4F4),
            shadowElevation = 10.dp,
            receiptData = ReceiptData(
                sectionsData = listOf(
                    ZapSectionData(
                        title = "Contact Details",
                        items = listOf(
                            ReceiptSectionData(label = "Name", value = "Tim"),
                            ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                            ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                        )
                    ),
                    ZapSectionData(
                        title = "Transaction Details",
                        items = listOf(
                            ReceiptSectionData(label = "ID", value = "#120304050-1"),
                            ReceiptSectionData(label = "Date", value = "12-Dec-2024"),
                            ReceiptSectionData(label = "Time", value = "12:30 PM")
                        )
                    )
                ),
                totalSectionData = ReceiptSectionData(label = "Total", value = "3500 Rs"),
                descriptionSectionData = ReceiptSectionData(
                    label = "Description",
                    value = "Wholesale product Payment sent to Tim."
                )
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
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = receiptSectionData.label.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFFF5F4F4)
                    )
                    Text(
                        text = receiptSectionData.value.toString(),
                        color = Color(0xFFF5F4F4)
                    )
                }
            },
            footerSectionContent = { receiptSectionData ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = receiptSectionData.label.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFFF5F4F4)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = receiptSectionData.value.toString(),
                        color = Color(0xFFF5F4F4)
                    )
                }
            }
        )

        // Example 2: Light themed receipt
        Text(
            text = "Light Theme Receipt",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        Receipt(
            dashesColor = Color(0xFF333333),
            backgroundColor = Color(0xFFFAFAFA),
            contentColor = Color(0xFF2F2F2F),
            shadowElevation = 8.dp,
            receiptData = ReceiptData(
                sectionsData = listOf(
                    ZapSectionData(
                        title = "Order Details",
                        items = listOf(
                            ReceiptSectionData(label = "Item", value = "Premium Coffee"),
                            ReceiptSectionData(label = "Quantity", value = "2x"),
                            ReceiptSectionData(label = "Size", value = "Large")
                        )
                    )
                ),
                totalSectionData = ReceiptSectionData(label = "Total Amount", value = "$12.50"),
                descriptionSectionData = ReceiptSectionData(
                    label = "Thank You!",
                    value = "Visit us again for more amazing coffee."
                )
            ),
            ticketSectionContent = { sectionData ->
                TicketSectionItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentColor = Color(0xFF2F2F2F),
                    sectionData = sectionData
                )
            },
            totalSectionContent = { receiptSectionData ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = receiptSectionData.label.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF2F2F2F)
                    )
                    Text(
                        text = receiptSectionData.value.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF2F2F2F)
                    )
                }
            },
            footerSectionContent = { receiptSectionData ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = receiptSectionData.label.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF2F2F2F)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = receiptSectionData.value.toString(),
                        color = Color(0xFF2F2F2F),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReceiptDemoPreview() {
    WorkshopTheme {
        ReceiptDemo()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DarkReceiptPreview() {
    WorkshopTheme {
        Receipt(
            dashesColor = Color(0xFFF5F4F4),
            backgroundColor = Color(0xFF2F2F2F),
            contentColor = Color(0xFFF5F4F4),
            shadowElevation = 10.dp,
            receiptData = ReceiptData(
                sectionsData = listOf(
                    ZapSectionData(
                        title = "Contact Details",
                        items = listOf(
                            ReceiptSectionData(label = "Name", value = "Tim"),
                            ReceiptSectionData(label = "Bank Name", value = "Some Bank"),
                            ReceiptSectionData(label = "IBAN", value = "PK36SCBL0000001123456702")
                        )
                    ),
                    ZapSectionData(
                        title = "Transaction Details",
                        items = listOf(
                            ReceiptSectionData(label = "ID", value = "#120304050-1"),
                            ReceiptSectionData(label = "Date", value = "12-Dec-2024"),
                            ReceiptSectionData(label = "Time", value = "12:30 PM")
                        )
                    )
                ),
                totalSectionData = ReceiptSectionData(label = "Total", value = "3500 Rs"),
                descriptionSectionData = ReceiptSectionData(
                    label = "Description",
                    value = "Wholesale product Payment sent to Tim."
                )
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
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = receiptSectionData.label.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFFF5F4F4)
                    )
                    Text(
                        text = receiptSectionData.value.toString(),
                        color = Color(0xFFF5F4F4)
                    )
                }
            },
            footerSectionContent = { receiptSectionData ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = receiptSectionData.label.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFFF5F4F4)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = receiptSectionData.value.toString(),
                        color = Color(0xFFF5F4F4)
                    )
                }
            }
        )
    }
}
