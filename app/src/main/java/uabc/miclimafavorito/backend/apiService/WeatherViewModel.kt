package uabc.miclimafavorito.backend.apiService

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import uabc.miclimafavorito.data.weather.WeatherResponse
import uabc.miclimafavorito.data.weather.SearchResponse
import android.util.Log

class WeatherViewModel : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    private val _citiesState = MutableStateFlow<List<SearchResponse>>(emptyList())
    val citiesState: StateFlow<List<SearchResponse>> = _citiesState

    fun getWeather(ciudad: String) {
        viewModelScope.launch {
            val data = fetchWeatherData(ciudad)
            _weatherState.value = data
        }
    }

    fun getCities(ciudad: String) {
        viewModelScope.launch {
            val data = fetchCities(ciudad)
            _citiesState.value = data
        }
    }

    suspend fun getWeatherSuspend(ciudad: String): WeatherResponse {
        return fetchWeatherData(ciudad)
    }


}
