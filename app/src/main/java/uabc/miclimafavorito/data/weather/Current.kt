package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("last_updated") val lastUpdated: String = "",           // Última actualización de datos del clima
    @SerializedName("temp_c") val tempC: Double             = 0.0,          // Temperatura en grados Celsius
    @SerializedName("is_day") val isDay: Int                = 0,            // Indicador si es de día (1) o de noche (0)
    @SerializedName("condition") val condition: Condition   = Condition(),  // Condición climática actual (descripción + código)
    @SerializedName("wind_kph") val windKph: Double         = 0.0,          // Velocidad del viento en km/h
    @SerializedName("wind_dir") val windDir: String         = "",           // Dirección del viento (abreviatura cardinal, ej. SE)
    @SerializedName("pressure_mb") val pressureMb: Double   = 0.0,          // Presión atmosférica en milibares
    @SerializedName("precip_mm") val precipMm: Double       = 0.0,          // Precipitación en milímetros
    @SerializedName("humidity") val humidity: Int           = 0,            // Porcentaje de humedad relativa
    @SerializedName("cloud") val cloud: Int                 = 0,            // Porcentaje de nubosidad
    @SerializedName("feelslike_c") val feelsLikeC: Double   = 0.0,          // Sensación térmica en grados Celsius
    @SerializedName("vis_km") val visibilityKm: Double      = 0.0,          // Visibilidad en kilómetros
    @SerializedName("gust_kph") val gustKph: Double         = 0.0,          // Ráfaga de viento máxima en km/h
    @SerializedName("uv") val uv: Double                    = 0.0           // Índice UV
    /*
            Índice UV	    Nivel de riesgo
            0–2	            Bajo
            3–5	            Moderado
            6–7	            Alto
            8–10	        Muy alto
            11+	            Extremo
    */
)
