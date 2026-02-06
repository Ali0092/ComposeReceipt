package com.example.workshop.demos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.receiptui.components.SharpCorneredTicket
import com.receiptui.components.SharpCorneredTicketCustom
import com.receiptui.modals.ReceiptSectionData
import com.receiptui.modals.ZapSectionData

/**
 * Demo screen showcasing all sharp-cornered (zigzag/sawblade) ticket variations:
 * - Default symmetric zigzag
 * - Asymmetric zigzag (different top and bottom)
 * - Custom content variants
 * - Different styling options
 */
@Composable
fun SharpCorneredTicketDemo(modifier: Modifier = Modifier) {
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
            text = "Sharp Cornered (Zigzag) Ticket Demo",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center)
        )

        // Example 1: Default symmetric zigzag
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

        // Example 2: Asymmetric zigzag
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

        // Example 3: Large zigzag teeth
        Text(
            text = "Large Zigzag Ticket",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicket(
            sectionData = ZapSectionData(
                title = "Event Admission",
                items = listOf(
                    ReceiptSectionData(label = "Event", value = "Music Festival"),
                    ReceiptSectionData(label = "Gate", value = "A-12"),
                    ReceiptSectionData(label = "Time", value = "6:00 PM")
                )
            ),
            topZigzagDepth = 12.dp,
            topZigzagWidth = 24.dp,
            bottomZigzagDepth = 12.dp,
            bottomZigzagWidth = 24.dp,
            backgroundColor = Color(0xFFFF5722),
            contentColor = Color.White,
            shadowElevation = 8.dp,
            tonalElevation = 4.dp
        )

        // Example 4: Fine/small zigzag
        Text(
            text = "Fine Zigzag Ticket",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicket(
            sectionData = ZapSectionData(
                title = "Premium Pass",
                items = listOf(
                    ReceiptSectionData(label = "Type", value = "VIP"),
                    ReceiptSectionData(label = "Access", value = "Unlimited"),
                    ReceiptSectionData(label = "Valid", value = "1 Year")
                )
            ),
            topZigzagDepth = 4.dp,
            topZigzagWidth = 8.dp,
            bottomZigzagDepth = 4.dp,
            bottomZigzagWidth = 8.dp,
            backgroundColor = Color(0xFF9C27B0),
            contentColor = Color.White,
            shadowElevation = 10.dp,
            tonalElevation = 6.dp
        )

        // Example 5: Custom content variant
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

        // Example 6: Custom variant for coupon/voucher
        Text(
            text = "Zigzag Coupon Style",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicketCustom(
            backgroundColor = Color(0xFF4CAF50),
            topZigzagDepth = 8.dp,
            topZigzagWidth = 16.dp,
            bottomZigzagDepth = 8.dp,
            bottomZigzagWidth = 16.dp,
            shadowElevation = 8.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "25% OFF",
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "SUMMER SALE",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Use code: SUMMER25",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        )

        // Example 7: Movie ticket style
        Text(
            text = "Movie Ticket Style",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        SharpCorneredTicket(
            sectionData = ZapSectionData(
                title = "ADMIT ONE",
                items = listOf(
                    ReceiptSectionData(label = "Movie", value = "Action Hero 2026"),
                    ReceiptSectionData(label = "Screen", value = "IMAX 3"),
                    ReceiptSectionData(label = "Seat", value = "H-15"),
                    ReceiptSectionData(label = "Show", value = "7:30 PM")
                )
            ),
            topZigzagDepth = 10.dp,
            topZigzagWidth = 20.dp,
            bottomZigzagDepth = 10.dp,
            bottomZigzagWidth = 20.dp,
            backgroundColor = Color(0xFF1976D2),
            contentColor = Color.White,
            shadowElevation = 12.dp,
            tonalElevation = 6.dp
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SharpCorneredTicketDemoPreview() {
    WorkshopTheme {
        SharpCorneredTicketDemo()
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun DefaultZigzagTicketPreview() {
    WorkshopTheme {
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
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun AsymmetricZigzagTicketPreview() {
    WorkshopTheme {
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
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun MovieTicketPreview() {
    WorkshopTheme {
        SharpCorneredTicket(
            sectionData = ZapSectionData(
                title = "ADMIT ONE",
                items = listOf(
                    ReceiptSectionData(label = "Movie", value = "Action Hero 2026"),
                    ReceiptSectionData(label = "Screen", value = "IMAX 3"),
                    ReceiptSectionData(label = "Seat", value = "H-15"),
                    ReceiptSectionData(label = "Show", value = "7:30 PM")
                )
            ),
            topZigzagDepth = 10.dp,
            topZigzagWidth = 20.dp,
            bottomZigzagDepth = 10.dp,
            bottomZigzagWidth = 20.dp,
            backgroundColor = Color(0xFF1976D2),
            contentColor = Color.White,
            shadowElevation = 12.dp,
            tonalElevation = 6.dp
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun CouponStylePreview() {
    WorkshopTheme {
        SharpCorneredTicketCustom(
            backgroundColor = Color(0xFF4CAF50),
            topZigzagDepth = 8.dp,
            topZigzagWidth = 16.dp,
            bottomZigzagDepth = 8.dp,
            bottomZigzagWidth = 16.dp,
            shadowElevation = 8.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "25% OFF",
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "SUMMER SALE",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Use code: SUMMER25",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun CustomLayoutZigzagPreview() {
    WorkshopTheme {
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
    }
}
