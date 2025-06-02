package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.backend.components.getUVColor

@Composable
fun UVIndexIndicator(
    uvIndex: Double,
    modifier: Modifier = Modifier,
    circleSize: Dp
) {
    val circleColor = getUVColor(uvIndex)

    Box(
        modifier = modifier
            .size(circleSize)
            .background(color = circleColor, shape = CircleShape)
    )
}
