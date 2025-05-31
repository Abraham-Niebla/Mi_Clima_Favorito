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

@Composable
fun CityAddScreen(
    cityUrl: String,
    modifier: Modifier,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {}
) {
    val weatherViewModel: WeatherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val weather by weatherViewModel.weatherState.collectAsState()

    LaunchedEffect(cityUrl) {
        weatherViewModel.getWeather(cityUrl)
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
            onFavoriteClick = onFavoriteClick
        )
    }
}