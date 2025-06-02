package uabc.miclimafavorito.backend.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.R

@Composable
fun getUV(uv: Double): String{
    return when {
        uv in 0.0..2.0      -> stringResource(R.string.uv_low)
        uv in 3.0..5.0      -> stringResource(R.string.uv_moderate)
        uv in 6.0..7.0      -> stringResource(R.string.uv_high)
        uv in 8.0..10.0     -> stringResource(R.string.uv_very_high)
        uv >= 11.0          -> stringResource(R.string.uv_extreme)
        else                -> stringResource(R.string.uv_unknown)
    }
}
/*
        Índice UV	    Nivel de riesgo

        0–2	            Bajo
        3–5	            Moderado
        6–7	            Alto
        8–10	        Muy alto
        11+	            Extremo
*/