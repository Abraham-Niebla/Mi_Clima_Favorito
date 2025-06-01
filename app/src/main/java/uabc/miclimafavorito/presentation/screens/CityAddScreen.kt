package uabc.miclimafavorito.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.backend.apiService.WeatherViewModel
import uabc.miclimafavorito.data.weather.WeatherResponse
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import uabc.miclimafavorito.backend.database.CityViewModel
import uabc.miclimafavorito.data.city.City

@Composable
fun CityAddScreen(
    cityUrl: String,
    modifier: Modifier,
    cityViewModel: CityViewModel
) {
    var isFavorite by remember { mutableStateOf(false) }
    val weatherViewModel: WeatherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val weather by weatherViewModel.weatherState.collectAsState()
    val cityState by cityViewModel.selectedCity.collectAsState()

    LaunchedEffect(cityUrl) {
        weatherViewModel.getWeather(cityUrl)
        cityViewModel.getCityByUrl(cityUrl)
    }
    // Cuando cambie el resultado de búsqueda
    LaunchedEffect(cityState) {
        isFavorite = cityState != null
    }

    if (weather == null) {
        // Mostrar carga mientras no hay datos
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Cargando datos",
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else {
        Log.d("CityAddScreen", "weather: $weather")
        // Ya hay datos, mostrar UI que ya tienes
        CityAddView(
            weather = weather ?: WeatherResponse(),
            isFavorite = isFavorite,
            onFavoriteClick = {
                if (isFavorite) {
                    cityState?.let { cityViewModel.deleteCity(it) }
                } else {
                    weather?.let {
                        val newCity = City(
                            name = it.location.name,
                            url = cityUrl
                        )
                        cityViewModel.insertCity(newCity)
                    }
                }
                isFavorite = !isFavorite
            }
        )
    }
}