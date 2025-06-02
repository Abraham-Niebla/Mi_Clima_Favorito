package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import uabc.miclimafavorito.data.weather.WeatherResponse


@Composable
fun CityCard(city: WeatherResponse) {
    ElevatedCard(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(24.dp)
        ) {
            item {
                Text(
                    text = city.location.name,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            item {
                Text(
                    text = "${city.location.region}, ${city.location.country}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            item {
                Text(
                    text = "Temp: ${city.current.tempC}°C",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            // Puedes seguir agregando más elementos aquí si el contenido crece
        }
    }
}
