package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("tz_id") val tzId: String           = "",               // Zona horaria
    @SerializedName("localtime") val localtime: String  = "",               // Fecha y hora local como cadena

    @SerializedName("name") val name: String            = "No encontrado",  // Nombre de la ciudad
    @SerializedName("region") val region: String        = "",               // Región o estado
    @SerializedName("country") val country: String      = "",               // País
    @SerializedName("lat") val lat: Double              = 0.0,              // Latitud
    @SerializedName("lon") val lon: Double              = 0.0,              // Longitud
)