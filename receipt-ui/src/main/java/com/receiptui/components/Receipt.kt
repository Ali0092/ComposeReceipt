package com.receiptui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.receiptui.shapes.ReceiptFooter
import com.receiptui.shapes.TicketShape
import com.receiptui.shapes.TopEdgeStyle

@Composable
fun Receipt(modifier: Modifier = Modifier, shapeColor: Color = Color(0xFFD0D0D0)) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = TicketShape(
                topEdgeStyle = TopEdgeStyle.Rounded
            ),
            color = shapeColor
        ) {}
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = TicketShape(),
            color = shapeColor
        ) {}
        DashedLine(modifier = Modifier.padding(horizontal = 8.dp), dashColor = Color.DarkGray, gapColor = shapeColor)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = TicketShape(),
            color = shapeColor
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Total", style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Medium))
                Text(text = "1023 Rs", style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold))
            }
        }
        DashedLine(modifier = Modifier.padding(horizontal = 8.dp), dashColor = Color.DarkGray, gapColor = shapeColor)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = ReceiptFooter(),
            color = shapeColor
        ) {
        }
    }

}
