package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class ForecastDay(
    @SerializedName("date") val date: String    = "00",       // Fecha del pronóstico
    @SerializedName("day") val day: Day         = Day()     // Datos del día
)