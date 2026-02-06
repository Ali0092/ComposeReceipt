package com.example.workshop.demos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.workshop.ui.theme.backgroundColor
import com.receiptui.components.ReceiptTicketComponent
import com.receiptui.components.ReceiptTicketCustomComponent
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData
import com.receiptui.shapes.TopEdgeStyle

/**
 * Demo screen showcasing all ticket component variations:
 * - Inward curved top edge
 * - Rounded top edge
 * - Flat top edge
 * - Custom content variant
 */
@Composable
fun TicketDemo(modifier: Modifier = Modifier) {
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
            text = "Ticket Component Demo",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center)
        )

        // Example 1: Inward curved top edge
        Text(
            text = "Ticket with Inward Curved Top (with shadow)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Inward,
            sectionData = ZapSectionData(
                title = "Contact Details",
                items = listOf(
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

        // Example 2: Rounded top edge
        Text(
            text = "Ticket with Rounded Top (elevated shadow)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Rounded,
            sectionData = ZapSectionData(
                title = "Event Details",
                items = listOf(
                    ReceiptSectionData(label = "Event", value = "Concert Night"),
                    ReceiptSectionData(label = "Venue", value = "Madison Square"),
                    ReceiptSectionData(label = "Date", value = "Jan 25, 2026")
                )
            ),
            backgroundColor = Color(0xFF2F2F2F),
            contentColor = Color(0xFFF5F4F4),
            shadowElevation = 12.dp
        )

        // Example 3: Flat top edge
        Text(
            text = "Ticket with Flat Top",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Flat,
            sectionData = ZapSectionData(
                title = "Booking Information",
                items = listOf(
                    ReceiptSectionData(label = "Booking ID", value = "#BK12345"),
                    ReceiptSectionData(label = "Service", value = "Hotel Stay"),
                    ReceiptSectionData(label = "Duration", value = "3 Nights")
                )
            ),
            backgroundColor = Color(0xFF091F65),
            contentColor = Color(0xFFEAEAEA),
            shadowElevation = 8.dp
        )

        // Example 4: Custom padding and styling
        Text(
            text = "Ticket with Large Padding",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Inward,
            sectionData = ZapSectionData(
                title = "Premium Ticket",
                items = listOf(
                    ReceiptSectionData(label = "Type", value = "VIP"),
                    ReceiptSectionData(label = "Access", value = "All Areas"),
                    ReceiptSectionData(label = "Perks", value = "Meet & Greet")
                )
            ),
            padding = PaddingValues(40.dp),
            roundedCornerRadius = 30.dp,
            inwardCornerRadius = 20.dp,
            backgroundColor = Color(0xFF4CAF50),
            contentColor = Color.White,
            shadowElevation = 10.dp
        )

        // Example 5: Custom content variant
        Text(
            text = "Ticket with Custom Content",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptTicketCustomComponent(
            topEdgeStyle = TopEdgeStyle.Inward,
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            shadowElevation = 8.dp,
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Custom Receipt\nComponent",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
                    )
                }
            }
        )

        // Example 6: Another custom variant
        ReceiptTicketCustomComponent(
            topEdgeStyle = TopEdgeStyle.Rounded,
            backgroundColor = Color(0xFFFF5722),
            roundedCornerRadius = 28.dp,
            shadowElevation = 12.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Special Offer",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "50% OFF",
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Valid until: Jan 31, 2026",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TicketDemoPreview() {
    WorkshopTheme {
        TicketDemo()
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun InwardTicketPreview() {
    WorkshopTheme {
        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Inward,
            sectionData = ZapSectionData(
                title = "Contact Details",
                items = listOf(
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
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun RoundedTicketPreview() {
    WorkshopTheme {
        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Rounded,
            sectionData = ZapSectionData(
                title = "Event Details",
                items = listOf(
                    ReceiptSectionData(label = "Event", value = "Concert Night"),
                    ReceiptSectionData(label = "Venue", value = "Madison Square"),
                    ReceiptSectionData(label = "Date", value = "Jan 25, 2026")
                )
            ),
            backgroundColor = Color(0xFF2F2F2F),
            contentColor = Color(0xFFF5F4F4),
            shadowElevation = 12.dp
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun FlatTicketPreview() {
    WorkshopTheme {
        ReceiptTicketComponent(
            topEdgeStyle = TopEdgeStyle.Flat,
            sectionData = ZapSectionData(
                title = "Booking Information",
                items = listOf(
                    ReceiptSectionData(label = "Booking ID", value = "#BK12345"),
                    ReceiptSectionData(label = "Service", value = "Hotel Stay"),
                    ReceiptSectionData(label = "Duration", value = "3 Nights")
                )
            ),
            backgroundColor = Color(0xFF091F65),
            contentColor = Color(0xFFEAEAEA),
            shadowElevation = 8.dp
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun CustomTicketPreview() {
    WorkshopTheme {
        ReceiptTicketCustomComponent(
            topEdgeStyle = TopEdgeStyle.Rounded,
            backgroundColor = Color(0xFFFF5722),
            roundedCornerRadius = 28.dp,
            shadowElevation = 12.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Special Offer",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "50% OFF",
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Valid until: Jan 31, 2026",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        )
    }
}
