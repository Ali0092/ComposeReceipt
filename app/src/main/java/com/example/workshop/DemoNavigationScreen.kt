package com.example.workshop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workshop.demos.FooterDemo
import com.example.workshop.demos.ReceiptDemo
import com.example.workshop.demos.SharpCorneredTicketDemo
import com.example.workshop.demos.TicketDemo
import com.example.workshop.ui.theme.WorkshopTheme

/**
 * Main navigation screen for all component demos.
 * Allows users to navigate between different component type demonstrations.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoNavigationScreen(modifier: Modifier = Modifier) {
    var selectedDemo by remember { mutableStateOf<DemoType?>(null) }

    when (selectedDemo) {
        DemoType.RECEIPT -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Receipt Component") },
                        navigationIcon = {
                            IconButton(onClick = { selectedDemo = null }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                ReceiptDemo(modifier = Modifier.padding(innerPadding))
            }
        }
        DemoType.TICKET -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Ticket Components") },
                        navigationIcon = {
                            IconButton(onClick = { selectedDemo = null }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                TicketDemo(modifier = Modifier.padding(innerPadding))
            }
        }
        DemoType.FOOTER -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Footer Components") },
                        navigationIcon = {
                            IconButton(onClick = { selectedDemo = null }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                FooterDemo(modifier = Modifier.padding(innerPadding))
            }
        }
        DemoType.SHARP_CORNERED -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Zigzag Tickets") },
                        navigationIcon = {
                            IconButton(onClick = { selectedDemo = null }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                SharpCorneredTicketDemo(modifier = Modifier.padding(innerPadding))
            }
        }
        null -> {
            // Show navigation menu
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "ComposeReceipt\nComponent Demos",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Select a component type to view examples",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(48.dp))

                // Receipt Component Button
                DemoNavigationButton(
                    title = "Receipt Component",
                    description = "Complete receipt with multiple sections",
                    onClick = { selectedDemo = DemoType.RECEIPT }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Ticket Component Button
                DemoNavigationButton(
                    title = "Ticket Components",
                    description = "Tickets with Inward, Rounded, and Flat edges",
                    onClick = { selectedDemo = DemoType.TICKET }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Footer Component Button
                DemoNavigationButton(
                    title = "Footer Components",
                    description = "Scalloped footer variations",
                    onClick = { selectedDemo = DemoType.FOOTER }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Sharp Cornered Ticket Button
                DemoNavigationButton(
                    title = "Zigzag Tickets",
                    description = "Sharp-cornered tickets with zigzag edges",
                    onClick = { selectedDemo = DemoType.SHARP_CORNERED }
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "v1.0.2",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                )
            }
        }
    }
}

@Composable
private fun DemoNavigationButton(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

enum class DemoType {
    RECEIPT,
    TICKET,
    FOOTER,
    SHARP_CORNERED
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DemoNavigationScreenPreview() {
    WorkshopTheme {
        DemoNavigationScreen()
    }
}
