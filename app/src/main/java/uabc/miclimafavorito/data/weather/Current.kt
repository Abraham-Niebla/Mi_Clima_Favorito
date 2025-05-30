package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Current(
//    @SerializedName("last_updated_epoch") val lastUpdatedEpoch: Long,
    @SerializedName("last_updated") val lastUpdated: String = "",           // Fecha y hora de última actualización
    @SerializedName("temp_c") val temperatureC: Double = 0.0,               // Temperatura °C
    @SerializedName("temp_f") val temperatureF: Double = 0.0,               // Temperatura °F
    @SerializedName("is_day") val isDay: Int = 1,                           // Es de día?
    @SerializedName("condition") val condition: Condition = Condition(),    // Condición del clima
    @SerializedName("wind_mph") val windMph: Double = 0.0,                  // Velocidad del viento Mi/h
    @SerializedName("wind_kph") val windKph: Double = 0.0,                  // Velocidad del viento km/h
//    @SerializedName("wind_degree") val windDegree: Int,
    @SerializedName("wind_dir") val windDirection: String = "",             // Dirección del viento
    @SerializedName("pressure_mb") val pressureMb: Double = 0.0,            // Presión atmosférica milibares (mb)
    @SerializedName("pressure_in") val pressureIn: Double = 0.0,            // Presión atmosférica pulgadas (in)
    @SerializedName("precip_mm") val precipitationMm: Double = 0.0,         // Precipitación mm
    @SerializedName("precip_in") val precipitationIn: Double = 0.0,         // Precipitación pulgadas
    @SerializedName("humidity") val humidity: Int = 0,                      // Humedad %
    @SerializedName("cloud") val cloud: Int = 0,                            // Nubosidad % (cuán cubierto está el cielo)
    @SerializedName("feelslike_c") val feelsLikeC: Double = 0.0,            // Sensación térmica °C
    @SerializedName("feelslike_f") val feelsLikeF: Double = 0.0,            // Sensación térmica °F
//    @SerializedName("windchill_c") val windChillC: Double,
//    @SerializedName("windchill_f") val windChillF: Double,
//    @SerializedName("heatindex_c") val heatIndexC: Double,
//    @SerializedName("heatindex_f") val heatIndexF: Double,
//    @SerializedName("dewpoint_c") val dewPointC: Double,
//    @SerializedName("dewpoint_f") val dewPointF: Double,
    @SerializedName("vis_km") val visibilityKm: Double = 0.0,               // Visibilidad km/h
    @SerializedName("vis_miles") val visibilityMiles: Double = 0.0,         // Visibilidad Mi/h
    @SerializedName("uv") val uvIndex: Double = 0.0,                        // Índice ultravioleta
    /*
                Índice UV	    Nivel de riesgo
                0–2	            Bajo
                3–5	            Moderado
                6–7	            Alto
                8–10	        Muy alto
                11+	            Extremo
    */
    @SerializedName("gust_mph") val gustMph: Double = 0.0,                  // Ráfagas de viento Mi/h
    @SerializedName("gust_kph") val gustKph: Double = 0.0                   // Ráfagas de viento km/h
)
