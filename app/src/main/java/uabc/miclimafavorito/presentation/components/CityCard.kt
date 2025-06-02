package uabc.miclimafavorito.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import uabc.miclimafavorito.data.weather.WeatherResponse
import uabc.miclimafavorito.ui.theme.extendedColors


@Composable
fun CityCard(city: WeatherResponse) {
    val context = LocalContext.current // Get the current context

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
                    onClick = { locationQuery ->
                        // Handle the click to open Google Maps
                        val gmmIntentUri = Uri.parse("geo:0,0?q=$locationQuery")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps") // Specify Google Maps package
                        if (mapIntent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(mapIntent)
                        } else {
                            // If Google Maps app is not installed, open in a browser
                            val webIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$locationQuery")
                            val webIntent = Intent(Intent.ACTION_VIEW, webIntentUri)
                            context.startActivity(webIntent)
                        }
                    }
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