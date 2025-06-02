package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.ForecastDay
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import coil.compose.AsyncImage
import uabc.miclimafavorito.R
import uabc.miclimafavorito.globals.BASE_ICON_URL

@Composable
fun ColumnData(
    forecast: ForecastDay,
    modifier: Modifier
) {
    val fileName = forecast.day.condition.icon.substringAfterLast("/")
    val iconUrl = "https:${BASE_ICON_URL}/day/$fileName"

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("dd/MM")

    val date = LocalDate.parse(forecast.date, inputFormatter)
    val dayAbbreviated = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("es", "MX"))
    val formattedDate = date.format(outputFormatter)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Text(
            text = dayAbbreviated, //fecha Arriba dia de semana
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = formattedDate, //fecha Abajo dia/mes
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = iconUrl,
            contentDescription = forecast.day.condition.description,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.max_temp, forecast.day.maxTempC),
//            color = Color.Black,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = stringResource(R.string.min_temp, forecast.day.minTempC),
//            color = Color.Black,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = stringResource(R.string.prom_temp, forecast.day.avgTempC),
//            color = Color.Black,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = stringResource(R.string.prom_hr, forecast.day.avgHumidity),
//            color = Color.Black,
            style = MaterialTheme.typography.titleSmall
        )
    }
}
