package uabc.miclimafavorito.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.ForecastDay
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import coil.compose.AsyncImage

@Composable
fun ColumnData(
    forecast: ForecastDay,
    modifier: Modifier
) {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("dd/MM")

    val date = LocalDate.parse(forecast.date, inputFormatter)
    val dayAbbreviated = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("es", "MX"))
    val formattedDate = date.format(outputFormatter)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Text(
            text = dayAbbreviated, //fecha Arriba dia de semana
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = formattedDate, //fecha Abajo dia/mes
            style = MaterialTheme.typography.titleSmall
        )
//        Text(
//            text = forecast.day.condition.description, //pronostico
//            style = MaterialTheme.typography.bodySmall
//        )
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = forecast.day.condition.icon,
            contentDescription = forecast.day.condition.description,
            modifier = Modifier.height(50.dp) // ajusta el tamaño según tu diseño
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${forecast.day.maxTempC}°C",
//            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "${forecast.day.minTempC}°C",
//            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "${forecast.day.avgTempC}°C",
//            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "${forecast.day.avgHumidity}%",
//            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
