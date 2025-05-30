package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name") val name: String = "",                          // Ciudad
    @SerializedName("region") val region: String = "",                      // Estado o región
    @SerializedName("country") val country: String = "",                    // País
    @SerializedName("lat") val latitude: Double = 0.0,                      // Coordenada Latitud
    @SerializedName("lon") val longitude: Double = 0.0,                     // Coordenada Longitud
    @SerializedName("tz_id") val timeZoneId: String = "",                   // Zona horaria
//    @SerializedName("localtime_epoch") val localTimeEpoch: Long,
    @SerializedName("localtime") val localTime: String = ""                 // Fecha y Hora actuales en la ciudad
)
