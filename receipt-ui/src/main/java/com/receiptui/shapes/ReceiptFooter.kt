package com.receiptui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class ReceiptFooter(
    private val inwardCornerRadius: Dp = 8.dp,
    private val bottomCornerRadius: Dp = 25.dp,
    private val scalpDepth: Dp = 18.dp,
    private val scalpWidth: Dp = 24.dp,
    private val scalpGap: Dp = 2.dp,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val width = size.width
            val height = size.height
            val inwardRadiusPx = with(density) { inwardCornerRadius.toPx() }
            val bottomRadiusPx = with(density) { bottomCornerRadius.toPx() }
            val scalpDepthPx = with(density) { scalpDepth.toPx() }
            val scalpWidthPx = with(density) { scalpWidth.toPx() }
            val scalpGapPx = with(density) { scalpGap.toPx() }

            // Calculate available width for scallops (excluding bottom corner radii)
            val availableWidth = width - (2 * bottomRadiusPx)
            val scalpCount = maxOf(1, (availableWidth / scalpWidthPx).toInt())
            val actualScalpWidth = availableWidth / scalpCount

            // Draw path clockwise starting from top-left
            moveTo(0f, inwardRadiusPx)

            // Top-left inward rounded corner
            quadraticTo(
                x1 = inwardRadiusPx,
                y1 = inwardRadiusPx,
                x2 = inwardRadiusPx,
                y2 = 0f
            )

            // Top edge
            lineTo(width - inwardRadiusPx, 0f)

            // Top-right inward rounded corner
            quadraticTo(
                x1 = width - inwardRadiusPx,
                y1 = inwardRadiusPx,
                x2 = width,
                y2 = inwardRadiusPx
            )

            // Right straight side
            lineTo(width, height - bottomRadiusPx)

            // Bottom-right rounded corner (outward)
            quadraticTo(
                x1 = width,
                y1 = height,
                x2 = width - bottomRadiusPx,
                y2 = height
            )

            // Bottom scalloped edge (right to left)
            for (i in scalpCount - 1 downTo 0) {
                val xStart = bottomRadiusPx + ((i + 1) * actualScalpWidth)
                val xEnd = bottomRadiusPx + (i * actualScalpWidth)

                // Start position for this scallop (with gap on the right)
                val scalpStart = xStart - scalpGapPx / 2
                // End position for this scallop (with gap on the left)
                val scalpEnd = xEnd + scalpGapPx / 2
                // Control point for the curve
                val xControl = (scalpStart + scalpEnd) / 2f

                if (i == scalpCount - 1) {
                    // First scallop - draw line from corner to scallop start
                    lineTo(scalpStart, height)
                }

                // Draw the scallop curve
                quadraticTo(
                    x1 = xControl,
                    y1 = height - scalpDepthPx,
                    x2 = scalpEnd,
                    y2 = height
                )

                // Draw the flat gap to the next scallop
                if (i > 0) {
                    val nextXStart = bottomRadiusPx + (i * actualScalpWidth)
                    val nextScalpStart = nextXStart - scalpGapPx / 2
                    lineTo(nextScalpStart, height)
                }
            }

            // Line to bottom-left corner
            lineTo(bottomRadiusPx, height)

            // Bottom-left rounded corner (outward)
            quadraticTo(
                x1 = 0f,
                y1 = height,
                x2 = 0f,
                y2 = height - bottomRadiusPx
            )

            // Left straight side
            lineTo(0f, inwardRadiusPx)

            close()
        }
        return Outline.Generic(path)
    }
}
