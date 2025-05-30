package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("location") val location: Location  = Location(),   // Información de la ubicación
    @SerializedName("current") val current: Current     = Current(),    // Condiciones actuales del clima
    @SerializedName("forecast") val forecast: Forecast  = Forecast(),   // Pronóstico del clima
)
