package uabc.miclimafavorito.backend.components

fun windDirToDegrees(dir: String): Float {
    return when(dir) {
        "N"     -> 180f         // Norte
        "S"     -> 0f           // Sur
        "E"     -> 270f         // Este
        "W"     -> 90f          // Oeste
        "NE"    -> 225f         // Noreste
        "NW"    -> 135f         // Noroeste
        "SE"    -> 315f         // Sureste
        "SW"    -> 45f          // Suroeste
        "NNE"   -> 202.5f       // Nornoreste
        "NNW"   -> 157.5f       // Nornoroeste
        "SSE"   -> 337.5f       // Sursureste
        "SSW"   -> 22.5f        // Sursuroeste
        "ENE"   -> 247.5f       // Estenoreste
        "ESE"   -> 292.5f       // Estesureste
        "WSW"   -> 67.5f        // Oestesuroeste
        "WNW"   -> 112.5f       // Oestenoroeste
        else    -> 0f           // Sin dirección
    }
}