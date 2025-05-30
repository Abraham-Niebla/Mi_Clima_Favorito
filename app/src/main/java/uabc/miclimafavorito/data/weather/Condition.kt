package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("text") val description: String = "",               // Descripción textual del tipo de clima
//    @SerializedName("icon") val iconUrl: String,
    @SerializedName("code") val code: Int = 1000                        // Identificador del tipo de clima
)
