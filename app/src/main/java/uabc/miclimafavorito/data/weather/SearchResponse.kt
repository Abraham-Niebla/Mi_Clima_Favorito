package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("id") val id: Int               = 0,    // Id de la ciudad
    @SerializedName("name") val name: String        = "",   // Ciudad
    @SerializedName("region") val region: String    = "",   // Estado o región
    @SerializedName("country") val country: String  = "",   // País
    @SerializedName("lat") val latitude: Double     = 0.0,  // Coordenada Latitud
    @SerializedName("lon") val longitude: Double    = 0.0,  // Coordenada Longitud
    @SerializedName("url") val localTime: String    = ""    // url de la ciudad
)
