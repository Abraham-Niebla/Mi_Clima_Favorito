package uabc.miclimafavorito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uabc.miclimafavorito.backend.apiService.WeatherViewModel
import uabc.miclimafavorito.backend.database.CityViewModel
import uabc.miclimafavorito.data.weather.WeatherResponse
import uabc.miclimafavorito.presentation.screens.WeatherScreen
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme

/*
* Vista inicial
* Se mostrará el estado actual del clima,
* así como el pronóstico del mismo día y los siguientes tres días.
* Esto lo hará para cada una de las ciudades favoritas.
* */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val cityViewModel: CityViewModel = viewModel()
            val favCities by cityViewModel.allCities.collectAsState()

            val weatherViewModel: WeatherViewModel = viewModel()
            var cityData by remember { mutableStateOf<List<WeatherResponse>>(emptyList()) }

            // ⚡ Cargar los datos de clima una vez que las ciudades favoritas estén disponibles
            LaunchedEffect(favCities) {
                val results = mutableListOf<WeatherResponse>()
                for (city in favCities) {
                    try {
                        val weather = weatherViewModel.getWeatherSuspend(city.idCiudad)
                        results.add(
                            WeatherResponse(
                                location = weather.location,
                                current = weather.current,
                                forecast = weather.forecast
                            )
                        )
                    } catch (e: Exception) {
                        results.add(
                            WeatherResponse()
                        )
                    }
                }
                cityData = results
            }

            MiClimaFavoritoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(
                        modifier = Modifier.padding(innerPadding),
                        cityData = cityData
                    )
                }
            }
        }
    }
}
