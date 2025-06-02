package uabc.miclimafavorito.backend.components

import java.math.BigDecimal
import java.math.RoundingMode

fun getAtm(mb: Double): Double{
    return BigDecimal(mb / 1013.25).setScale(2, RoundingMode.DOWN).toDouble()
}