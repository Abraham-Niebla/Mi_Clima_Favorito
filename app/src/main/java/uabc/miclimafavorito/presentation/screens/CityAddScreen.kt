package uabc.miclimafavorito.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
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
    cityId: Long,
    modifier: Modifier,
    cityViewModel: CityViewModel
) {
    var isFavorite by remember { mutableStateOf(false) }
    val weatherViewModel: WeatherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val weather by weatherViewModel.weatherState.collectAsState()
    val cityState by cityViewModel.selectedCity.collectAsState()

    LaunchedEffect(cityId) {
        weatherViewModel.getWeather(cityId)
        cityViewModel.getCityById(cityId)
    }
    // Cuando cambie el resultado de búsqueda
    LaunchedEffect(cityState) {
        isFavorite = cityState != null
    }

    if (weather == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
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
                            idCiudad = cityId
                        )
                        cityViewModel.insertCity(newCity)
                    }
                }
                isFavorite = !isFavorite
            }
        )
    }
}