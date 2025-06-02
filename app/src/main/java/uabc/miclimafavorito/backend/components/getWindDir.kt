package uabc.miclimafavorito.backend.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.R

@Composable
fun getWindDir(windDir: String): String {
    return when (windDir){
        "N"     -> stringResource(R.string.wind_n)
        "NNE"   -> stringResource(R.string.wind_nne)
        "NE"    -> stringResource(R.string.wind_ne)
        "ENE"   -> stringResource(R.string.wind_ene)
        "E"     -> stringResource(R.string.wind_e)
        "ESE"   -> stringResource(R.string.wind_ese)
        "SE"    -> stringResource(R.string.wind_se)
        "SSE"   -> stringResource(R.string.wind_sse)
        "S"     -> stringResource(R.string.wind_s)
        "SSW"   -> stringResource(R.string.wind_ssw)
        "SW"    -> stringResource(R.string.wind_sw)
        "WSW"   -> stringResource(R.string.wind_wsw)
        "W"     -> stringResource(R.string.wind_w)
        "WNW"   -> stringResource(R.string.wind_wnw)
        "NW"    -> stringResource(R.string.wind_nw)
        "NNW"   -> stringResource(R.string.wind_nnw)
        else    -> stringResource(R.string.wind_no_dir)
    }
}