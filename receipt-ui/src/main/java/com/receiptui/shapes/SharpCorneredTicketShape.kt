package com.receiptui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * A custom shape with sharp, saw blade-like zigzag edges on top and bottom.
 * Creates an angular, modern aesthetic for receipt/ticket components.
 *
 * @param topZigzagDepth Height of the triangular teeth on the top edge
 * @param topZigzagWidth Target width per tooth on the top edge (actual count calculated dynamically)
 * @param bottomZigzagDepth Height of the triangular teeth on the bottom edge
 * @param bottomZigzagWidth Target width per tooth on the bottom edge (actual count calculated dynamically)
 */
class SharpCorneredTicketShape(
    private val topZigzagDepth: Dp = 8.dp,
    private val topZigzagWidth: Dp = 16.dp,
    private val bottomZigzagDepth: Dp = 8.dp,
    private val bottomZigzagWidth: Dp = 16.dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: androidx.compose.ui.unit.Density
    ): Outline {
        val path = Path().apply {
            val width = size.width
            val height = size.height

            with(density) {
                val topDepthPx = topZigzagDepth.toPx()
                val topWidthPx = topZigzagWidth.toPx()
                val bottomDepthPx = bottomZigzagDepth.toPx()
                val bottomWidthPx = bottomZigzagWidth.toPx()

                // Calculate dynamic tooth count based on available width
                val topTeethCount = maxOf(1, (width / topWidthPx).toInt())
                val bottomTeethCount = maxOf(1, (width / bottomWidthPx).toInt())

                // Actual width per tooth (distributed evenly)
                val actualTopToothWidth = width / topTeethCount
                val actualBottomToothWidth = width / bottomTeethCount

                // Start at top-left baseline (after first tooth depth)
                moveTo(0f, topDepthPx)

                // Draw top zigzag (left to right) - triangular teeth pointing upward
                for (i in 0 until topTeethCount) {
                    val baseX = i * actualTopToothWidth
                    val peakX = baseX + (actualTopToothWidth / 2f)
                    val nextBaseX = (i + 1) * actualTopToothWidth

                    // Line to peak (going up)
                    lineTo(peakX, 0f)
                    // Line to next valley (going down to baseline)
                    lineTo(nextBaseX, topDepthPx)
                }

                // Draw right edge
                lineTo(width, height - bottomDepthPx)

                // Draw bottom zigzag (right to left) - triangular teeth pointing downward
                lineTo(width, height - bottomDepthPx)
                for (i in bottomTeethCount - 1 downTo 0) {
                    val baseX = (i + 1) * actualBottomToothWidth
                    val valleyX = i * actualBottomToothWidth + (actualBottomToothWidth / 2f)
                    val nextBaseX = i * actualBottomToothWidth

                    // Line to valley (going down)
                    lineTo(valleyX, height)
                    // Line to next peak (going up to baseline)
                    lineTo(nextBaseX, height - bottomDepthPx)
                }

                // Draw left edge back to start
                lineTo(0f, topDepthPx)

                close()
            }
        }

        return Outline.Generic(path)
    }
}
