package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("location") val location: Location = Location(),        // Datos de la ciudad
    @SerializedName("current") val current: Current = Current()             // Datos del clima
)
