package uabc.miclimafavorito.backend.apiService

import uabc.miclimafavorito.data.weather.SearchResponse
import uabc.miclimafavorito.data.weather.WeatherResponse
import uabc.miclimafavorito.globals.API_DAYS_FORECAST
import uabc.miclimafavorito.globals.API_KEY
import uabc.miclimafavorito.globals.API_LANG

suspend fun fetchWeatherData(idCiudad: Long): WeatherResponse {
    return try {
        RetrofitInstance.api.getCurrentWeather(
            apiKey = API_KEY,
            location = "id:$idCiudad" ,
            language = API_LANG,
            days = API_DAYS_FORECAST
        )
    } catch (e: Exception) {
        WeatherResponse()
    }
}

suspend fun fetchCities(ciudad: String): List<SearchResponse> {
    return try {
        RetrofitInstance.api.getSearchCities(
            apiKey = API_KEY,
            location = ciudad,
            language = API_LANG,
        )
    } catch (e: Exception) {
        listOf(SearchResponse())
    }
}