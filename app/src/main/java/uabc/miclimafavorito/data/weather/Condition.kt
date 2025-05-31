package uabc.miclimafavorito.data.weather

import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("text") val description: String = "No encontrado",  // Descripción de la condición climática (ej. "Nublado")
    @SerializedName("icon") val icon: String        = "",               // URL del ícono del estado del clima
    @SerializedName("code") val code: Int           = 0                 // Código de condición (según tabla de condiciones)
)
