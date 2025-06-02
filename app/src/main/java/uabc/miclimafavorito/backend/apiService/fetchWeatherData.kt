package uabc.miclimafavorito.backend.apiService

import uabc.miclimafavorito.data.weather.SearchResponse
import uabc.miclimafavorito.data.weather.WeatherResponse

suspend fun fetchWeatherData(idCiudad: Long): WeatherResponse {
    return try {
        RetrofitInstance.api.getCurrentWeather(
            apiKey = "06b8c71ee2f1412f8c871700252005",
            location = "id:$idCiudad" ,
            language = "es",
            days = 4
        )
    } catch (e: Exception) {
        WeatherResponse()
    }
}

suspend fun fetchCities(ciudad: String): List<SearchResponse> {
    return try {
        RetrofitInstance.api.getSearchCities(
            apiKey = "06b8c71ee2f1412f8c871700252005",
            location = ciudad,
            language = "es",
        )
    } catch (e: Exception) {
        listOf(SearchResponse())
    }
}