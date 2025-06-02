package uabc.miclimafavorito.backend.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getUVColor(uv: Double): Color{
    return when {
        uv in 0.0..2.9      -> Color(0xFF5ea500)
        uv in 3.0..5.9      -> Color(0xFFd08700)
        uv in 6.0..7.9      -> Color(0xFFf54900)
        uv in 8.0..10.9     -> Color(0xFFec003f)
        uv >= 11.0          -> Color(0xFF6e11b0)
        else                -> Color.Black
    }
}
/*
        Índice UV	    Nivel de riesgo

        0–2.9	            Bajo
        3–5.9	            Moderado
        6–7.9	            Alto
        8–10.9	        Muy alto
        11+	            Extremo
*/