package uabc.miclimafavorito.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.data.weather.WeatherResponse

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    cityData: List<WeatherResponse>
) {
    val isLoading = cityData.any {
        it.location.name.isBlank() || it.current.tempC == 0.0
    }

    if (isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        WeatherView(
            modifier = modifier,
            cityData = cityData
        )
    }
}
