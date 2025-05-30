package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("maxtemp_c") val maxTempC: Double                   = 0.0,          // Temperatura máxima en °C
    @SerializedName("mintemp_c") val minTempC: Double                   = 0.0,          // Temperatura mínima en °C
    @SerializedName("avgtemp_c") val avgTempC: Double                   = 0.0,          // Temperatura promedio en °C
    @SerializedName("maxwind_kph") val maxWindKph: Double               = 0.0,          // Viento máximo en km/h
    @SerializedName("avgvis_km") val avgVisibilityKm: Double            = 0.0,          // Visibilidad promedio en km
    @SerializedName("avghumidity") val avgHumidity: Int                 = 0,            // Humedad promedio en %
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int  = 0,            // Probabilidad diaria de lluvia (%)
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int  = 0,            // Probabilidad diaria de nieve (%)
    @SerializedName("condition") val condition: Condition               = Condition(),  // Condición climática general del día
    @SerializedName("uv") val uv: Double                                = 0.0           // Índice UV promedio del día
    /*
            Índice UV	    Nivel de riesgo
            0–2	            Bajo
            3–5	            Moderado
            6–7	            Alto
            8–10	        Muy alto
            11+	            Extremo
    */
)
