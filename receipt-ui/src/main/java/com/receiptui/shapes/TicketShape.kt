package com.receiptui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * A ticket-style shape with configurable top edge and inward bottom corners.
 */
class TicketShape(
    private val topEdgeStyle: TopEdgeStyle = TopEdgeStyle.Inward,
    private val roundedCornerRadius: Dp = 25.dp,
    private val inwardCornerRadius: Dp = 8.dp,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val width = size.width
            val height = size.height
            val roundedRadiusPx = with(density) { roundedCornerRadius.toPx() }
            val inwardRadiusPx = with(density) { inwardCornerRadius.toPx() }

            // Start drawing based on top edge style
            when (topEdgeStyle) {
                TopEdgeStyle.Flat -> {
                    // Flat top edge - start from top-left corner
                    moveTo(0f, 0f)
                    lineTo(width, 0f)
                    lineTo(width, height - inwardRadiusPx)
                }

                TopEdgeStyle.Rounded -> {
                    // Rounded (outward) top corners
                    moveTo(roundedRadiusPx, 0f)
                    lineTo(width - roundedRadiusPx, 0f)
                    quadraticTo(width, 0f, width, roundedRadiusPx)
                    lineTo(width, height - inwardRadiusPx)
                }

                TopEdgeStyle.Inward -> {
                    // Inward (ticket-style) top corners
                    moveTo(0f, inwardRadiusPx)
                    quadraticTo(
                        x1 = inwardRadiusPx,
                        y1 = inwardRadiusPx,
                        x2 = inwardRadiusPx,
                        y2 = 0f
                    )
                    lineTo(width - inwardRadiusPx, 0f)
                    quadraticTo(
                        x1 = width - inwardRadiusPx,
                        y1 = inwardRadiusPx,
                        x2 = width,
                        y2 = inwardRadiusPx
                    )
                    lineTo(width, height - inwardRadiusPx)
                }
            }

            // Bottom-right inward corner (ticket-style)
            quadraticTo(
                x1 = width - inwardRadiusPx,
                y1 = height - inwardRadiusPx,
                x2 = width - inwardRadiusPx,
                y2 = height
            )

            // Bottom edge
            lineTo(inwardRadiusPx, height)

            // Bottom-left inward corner (ticket-style)
            quadraticTo(
                x1 = inwardRadiusPx,
                y1 = height - inwardRadiusPx,
                x2 = 0f,
                y2 = height - inwardRadiusPx
            )

            // Left edge back to start
            when (topEdgeStyle) {
                TopEdgeStyle.Flat -> {
                    lineTo(0f, 0f)
                }

                TopEdgeStyle.Rounded -> {
                    lineTo(0f, roundedRadiusPx)
                    quadraticTo(0f, 0f, roundedRadiusPx, 0f)
                }

                TopEdgeStyle.Inward -> {
                    lineTo(0f, inwardRadiusPx)
                }
            }

            close()
        }
        return Outline.Generic(path)
    }
}
