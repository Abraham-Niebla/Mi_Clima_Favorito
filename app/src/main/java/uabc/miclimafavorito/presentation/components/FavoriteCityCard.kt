package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.ui.theme.extendedColors
import uabc.miclimafavorito.R
import uabc.miclimafavorito.globals.BASE_ICON_URL
import uabc.miclimafavorito.globals.ROUND_BORDERS_VALUE

@Composable
fun FavoriteCityCard(
    modifier: Modifier = Modifier,
    cityData: CityResponse,
    onClick: () -> Unit = {}
) {
    val fileName = cityData.current.condition.icon.substringAfterLast("/")
    val day = when (cityData.current.isDay) {
        1 -> "day"
        else -> "night"
    }
    val iconUrl = "https:${BASE_ICON_URL}/$day/$fileName"

    val backgroundColor = when (cityData.current.isDay) {
        0 -> MaterialTheme.extendedColors.nightContainer
        else -> MaterialTheme.extendedColors.dayContainer
    }
    val contentColor = when (cityData.current.isDay) {
        0 -> MaterialTheme.extendedColors.onNightContainer
        else -> MaterialTheme.extendedColors.onDayContainer
    }

    ElevatedCard(
        modifier = modifier
            .clickable { onClick() },
        colors = CardDefaults.elevatedCardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(ROUND_BORDERS_VALUE), // Bordes redondeados
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Primera columna: nombre y descripción
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = cityData.name,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${cityData.region}, ${cityData.country}",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
//                horizontalAlignment = Alignment.End
            ) {
                AsyncImage(
                    model = iconUrl,
                    contentDescription = cityData.current.condition.description,
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = stringResource(R.string.temp, cityData.current.tempC),
                    fontSize = 32.sp,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
