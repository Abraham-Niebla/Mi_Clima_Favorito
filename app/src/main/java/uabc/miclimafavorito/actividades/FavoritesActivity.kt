package uabc.miclimafavorito.actividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.forEach
import uabc.miclimafavorito.backend.apiService.WeatherViewModel
import uabc.miclimafavorito.presentation.screens.FavoritesView
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme
import uabc.miclimafavorito.backend.database.CityViewModel
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.data.weather.Current

/*
* Vista en donde se mostrarán todas las ciudades favoritas,
* en caso de no tener favoritas, se mostrará un mensaje indicandolo
* */
class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val intent = intent
//        val maxScore = intent.getIntExtra("maxScore", 0)

        enableEdgeToEdge()
        setContent {
            val vm: CityViewModel = viewModel()
            val favCities = vm.getAllCities()

            val weatherViewModel: WeatherViewModel = viewModel()
            val cityWeatherData by weatherViewModel.weatherState.collectAsState()

            var cityData = mutableListOf<CityResponse>()

            for (city in favCities) {
                weatherViewModel.getWeather(city.url)

                cityData.add(
                    CityResponse(
                        name = city.name,
                        region = cityWeatherData?.location?.region ?:   "Desconocido",
                        country = cityWeatherData?.location?.country ?: "Desconocido",
                        url = city.url,
                        current = cityWeatherData?.current ?: Current()  // Usa un Current vacío si es null
                    )
                )

            }

            MiClimaFavoritoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FavoritesView(
                        modifier = Modifier.padding(innerPadding),
                        cityData = cityData
                    )
                }
            }
        }
    }
}