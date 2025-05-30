package uabc.miclimafavorito.data.city

import com.google.gson.annotations.SerializedName
import uabc.miclimafavorito.data.weather.Current
import uabc.miclimafavorito.data.weather.Location

data class CityResponse(
    @SerializedName("name") val name: String        = "",           // Ciudad
    @SerializedName("region") val region: String    = "",           // Estado o región
    @SerializedName("country") val country: String  = "",           // País
    @SerializedName("url") val url: String    = "",           // url de la ciudad
    val current: Current                            = Current()     // estado actual del clima
)