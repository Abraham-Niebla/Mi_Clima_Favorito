package uabc.miclimafavorito.presentation.screens

import android.content.Intent
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
import androidx.compose.material3.Scaffold
import androidx.activity.compose.LocalActivity
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.MainActivity
import uabc.miclimafavorito.presentation.components.AppTopBar
import uabc.miclimafavorito.R
import uabc.miclimafavorito.actividades.FavoritesActivity

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = viewModel()
) {
    val activity = LocalActivity.current

    val weatherState by viewModel.weatherState.collectAsState()
    var cityInput by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.weather_title),  // define este string en strings.xml
                onBackClick = {
                    activity?.let {
                        val intent = Intent(it, FavoritesActivity::class.java)
                        it.startActivity(intent)
                    }
                },
                isMain = true
            )
        }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)  // para respetar el espacio del top bar
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
                Text(text = "Temperatura: ${weather.current.tempC} °C")
                Text(text = "Humedad: ${weather.current.humidity} %")
                Text(text = "Descripción: ${weather.current.condition.description}")
            }
        }
    }
}
