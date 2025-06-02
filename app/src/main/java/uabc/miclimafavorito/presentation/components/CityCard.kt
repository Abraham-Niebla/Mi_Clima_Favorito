package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import uabc.miclimafavorito.data.weather.WeatherResponse
import uabc.miclimafavorito.ui.theme.extendedColors


@Composable
fun CityCard(city: WeatherResponse) {

    val backgroundColor = when (city.current.isDay) {
        0 -> MaterialTheme.extendedColors.nightContainer
        else -> MaterialTheme.extendedColors.dayContainer
    }
    val contentColor = when (city.current.isDay) {
        0 -> MaterialTheme.extendedColors.onNightContainer
        else -> MaterialTheme.extendedColors.onDayContainer
    }

    ElevatedCard(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        LazyColumn(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                CityLocationCard(
                    modifier = Modifier,
                    locationData = city.location,
                    contentColor = contentColor,
                    onClick = {}
                )
            }

            item {
                CityConditionCard(
                    modifier = Modifier,
                    currentData = city.current,
                    maxTempC = city.forecast.forecastDay[0].day.maxTempC,
                    minTempC = city.forecast.forecastDay[0].day.minTempC,
                    contentColor = contentColor
                )
            }

            item {
                CityForecastCard(
                    modifier = Modifier,
                    forecastData = listOf(
                        city.forecast.forecastDay[1],
                        city.forecast.forecastDay[2],
                        city.forecast.forecastDay[3]
                    ),
                    contentColor = contentColor
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CityWindCard(
                        modifier = Modifier
                            .weight(1f),
                        currentData = city.current,
                        contentColor = contentColor
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // opcional para separar visualmente

                    CiryUVCard(
                        modifier = Modifier
                            .weight(1f),
                        currentData = city.current,
                        contentColor = contentColor
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CityPlus1DataCard(
                        modifier = Modifier
                            .weight(1f),
                        currentData = city.current,
                        contentColor = contentColor
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // opcional para separar visualmente

                    CityPlus2DataCard(
                        modifier = Modifier
                            .weight(1f),
                        currentData = city.current,
                        forecastDayData = city.forecast.forecastDay[0].day,
                        contentColor = contentColor,
                    )
                }
            }


        }
    }
}
