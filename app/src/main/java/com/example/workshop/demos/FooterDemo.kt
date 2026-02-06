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
import com.receiptui.components.ReceiptFooterComponent

/**
 * Demo screen showcasing all footer component variations:
 * - Footer with content
 * - Footer without content (decorative)
 * - Different styling options
 */
@Composable
fun FooterDemo(modifier: Modifier = Modifier) {
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
            text = "Footer Component Demo",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center)
        )

        // Example 1: Footer with content
        Text(
            text = "Receipt Footer (with content)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptFooterComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Wholesale product payment",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        )

        // Example 2: Footer without content (decorative)
        Text(
            text = "Receipt Footer (decorative only)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptFooterComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {}
        )

        // Example 3: Dark themed footer
        Text(
            text = "Dark Themed Footer",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptFooterComponent(
            backgroundColor = Color(0xFF2F2F2F),
            roundedCornerRadius = 25.dp,
            inwardCornerRadius = 18.dp,
            scallopGap = 2.dp,
            shadowElevation = 6.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Thank You!",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFFF5F4F4)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Visit us again for more amazing deals",
                        color = Color(0xFFF5F4F4),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )

        // Example 4: Colorful footer
        Text(
            text = "Colorful Footer",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptFooterComponent(
            backgroundColor = Color(0xFF4CAF50),
            roundedCornerRadius = 30.dp,
            inwardCornerRadius = 15.dp,
            scallopGap = 3.dp,
            shadowElevation = 8.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Success!",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Your payment has been processed successfully",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )

        // Example 5: Large scallop gaps
        Text(
            text = "Footer with Large Scallops",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptFooterComponent(
            backgroundColor = Color(0xFFFF9800),
            roundedCornerRadius = 35.dp,
            inwardCornerRadius = 25.dp,
            scallopGap = 5.dp,
            shadowElevation = 10.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Important Notice",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Please keep this receipt for your records",
                        color = Color.White.copy(alpha = 0.95f),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )

        // Example 6: Minimal footer
        Text(
            text = "Minimal Footer (no shadow)",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center)
        )

        ReceiptFooterComponent(
            backgroundColor = Color(0xFFE3F2FD),
            roundedCornerRadius = 20.dp,
            inwardCornerRadius = 12.dp,
            shadowElevation = 0.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Powered by ComposeReceipt",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF1976D2)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FooterDemoPreview() {
    WorkshopTheme {
        FooterDemo()
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun FooterWithContentPreview() {
    WorkshopTheme {
        ReceiptFooterComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Wholesale product payment",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun DarkFooterPreview() {
    WorkshopTheme {
        ReceiptFooterComponent(
            backgroundColor = Color(0xFF2F2F2F),
            roundedCornerRadius = 25.dp,
            inwardCornerRadius = 18.dp,
            scallopGap = 2.dp,
            shadowElevation = 6.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Thank You!",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFFF5F4F4)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Visit us again for more amazing deals",
                        color = Color(0xFFF5F4F4),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun ColorfulFooterPreview() {
    WorkshopTheme {
        ReceiptFooterComponent(
            backgroundColor = Color(0xFF4CAF50),
            roundedCornerRadius = 30.dp,
            inwardCornerRadius = 15.dp,
            scallopGap = 3.dp,
            shadowElevation = 8.dp,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Success!",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Your payment has been processed successfully",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun DecorativeFooterPreview() {
    WorkshopTheme {
        ReceiptFooterComponent(
            backgroundColor = backgroundColor,
            inwardCornerRadius = 20.dp,
            content = {}
        )
    }
}
