package uabc.miclimafavorito.backend.components

import uabc.miclimafavorito.globals.BASE_ICON_URL

fun getIconUrl(url: String, isDay: Int): String {
    val fileName = url.substringAfterLast("/")
    val day = when (isDay) {
        1       -> "day"
        else    -> "night"
    }
    return "https:${BASE_ICON_URL}/$day/$fileName"
}