package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.ui.theme.extendedColors

@Composable
fun FavoriteCityCard(
    modifier: Modifier = Modifier,
    cityData: CityResponse
) {

    val backgroundColor = when(cityData.current.isDay){
        0       ->  MaterialTheme.extendedColors.nightContainer
        else    ->  MaterialTheme.extendedColors.dayContainer
    }
    val contentColor = when(cityData.current.isDay){
        0       ->  MaterialTheme.extendedColors.onNightContainer
        else    ->  MaterialTheme.extendedColors.onDayContainer
    }

    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor  = backgroundColor,
            contentColor    = contentColor
        )
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

            // Segunda columna: temperatura, alineada a la derecha
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "$cityData.current.tempC",
                    fontSize = 32.sp,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}
