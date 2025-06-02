package uabc.miclimafavorito.backend.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.R

@Composable
fun getUVColor(uv: Double): Color{
    return when {
        uv in 0.0..2.0      -> Color(0xFF5ea500)
        uv in 3.0..5.0      -> Color(0xFFd08700)
        uv in 6.0..7.0      -> Color(0xFFf54900)
        uv in 8.0..10.0     -> Color(0xFFec003f)
        uv >= 11.0          -> Color(0xFF6e11b0)
        else                -> Color.Black
    }
}