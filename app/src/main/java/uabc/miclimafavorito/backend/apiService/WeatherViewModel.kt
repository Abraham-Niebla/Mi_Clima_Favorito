package uabc.miclimafavorito.backend.apiService

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import uabc.miclimafavorito.data.weather.WeatherResponse

class WeatherViewModel : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    fun getWeather(ciudad: String) {
        viewModelScope.launch {
            val data = fetchWeatherData(ciudad)
            _weatherState.value = data
        }
    }
}
