package uabc.miclimafavorito.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import uabc.miclimafavorito.backend.apiService.WeatherViewModel

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = viewModel()
) {
    var cityInput by remember { mutableStateOf("") }

    val weatherState by viewModel.weatherState.collectAsState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = cityInput,
            onValueChange = { cityInput = it },
            label = { Text("Ciudad") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.getWeather(cityInput) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buscar clima")
        }

        weatherState?.let { weather ->
            Text(text = "Ciudad: ${weather.location.name}")
            Text(text = "Temperatura: ${weather.current.temperatureC} °C")
            Text(text = "Humedad: ${weather.current.humidity} %")
            Text(text = "Descripción: ${weather.current.condition.description}")
        }
    }
}
