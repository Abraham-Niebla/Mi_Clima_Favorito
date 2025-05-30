package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("forecastday") val forecastDay: List<ForecastDay> = emptyList() // Lista de días con pronóstico
)