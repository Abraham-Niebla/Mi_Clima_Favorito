package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun WindDirectionArrow(
    windDegree: Float,
    modifier: Modifier = Modifier,
    arrowColor: Color = Color.Red,
    size: Dp
) {
    Box(
        modifier = modifier.size(size)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val center = Offset(size.toPx() / 2f, size.toPx() / 2f)
            val arrowLength = size.toPx() / 2.5f

            val adjustedAngle = (windDegree)

            rotate(degrees = adjustedAngle, pivot = center) {
                // Línea principal
                drawLine(
                    color = arrowColor,
                    start = center,
                    end = Offset(center.x, center.y - arrowLength),
                    strokeWidth = 8f
                )

                // Punta de flecha
                drawLine(
                    color = arrowColor,
                    start = Offset(center.x, center.y - arrowLength),
                    end = Offset(center.x - 15f, center.y - arrowLength + 20f),
                    strokeWidth = 8f
                )
                drawLine(
                    color = arrowColor,
                    start = Offset(center.x, center.y - arrowLength),
                    end = Offset(center.x + 15f, center.y - arrowLength + 20f),
                    strokeWidth = 8f
                )
            }
        }
    }
}
