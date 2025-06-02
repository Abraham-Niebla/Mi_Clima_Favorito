package uabc.miclimafavorito.actividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uabc.miclimafavorito.backend.apiService.WeatherViewModel
import uabc.miclimafavorito.backend.database.CityViewModel
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.data.weather.Current
import uabc.miclimafavorito.presentation.screens.FavoritesView
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme
import uabc.miclimafavorito.data.city.City

/*
* Vista en donde se mostrarán todas las ciudades favoritas,
* en caso de no tener favoritas, se mostrará un mensaje indicandolo
*/
class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val cityViewModel: CityViewModel = viewModel()
            val favCities by cityViewModel.allCities.collectAsState()

            val weatherViewModel: WeatherViewModel = viewModel()
            var cityData by remember { mutableStateOf<List<CityResponse>>(emptyList()) }

            // ⚡ Cargar los datos de clima una vez que las ciudades favoritas estén disponibles
            LaunchedEffect(favCities) {
                val results = mutableListOf<CityResponse>()
                for (city in favCities) {
                    try {
                        val weather = weatherViewModel.getWeatherSuspend(city.url)
                        results.add(
                            CityResponse(
                                name = city.name,
                                region = weather.location.region,
                                country = weather.location.country,
                                url = city.url,
                                current = weather.current
                            )
                        )
                    } catch (e: Exception) {
                        results.add(
                            CityResponse(
                                name = city.name,
                                region = "Desconocido",
                                country = "Desconocido",
                                url = city.url,
                                current = Current()
                            )
                        )
                    }
                }
                cityData = results
            }

            MiClimaFavoritoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FavoritesView(
                        modifier = Modifier.padding(innerPadding),
                        cityData = cityData,
                        onSwipe = { cityResponse ->
                            val city = City(
                                name = cityResponse.name,
                                url = cityResponse.url
                            )
                            cityViewModel.deleteCity(city)
                        }
                    )
                }
            }
        }
    }
}
