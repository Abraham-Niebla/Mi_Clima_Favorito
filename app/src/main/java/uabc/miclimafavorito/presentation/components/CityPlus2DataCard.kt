package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.R
import uabc.miclimafavorito.data.weather.Current
import uabc.miclimafavorito.data.weather.Day

@Composable
fun CityPlus2DataCard(
    modifier: Modifier,
    currentData: Current,
    forecastDayData: Day,
    contentColor: Color
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface.copy(alpha = 0.1f),
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.data2_sens_termica),
                    modifier = Modifier.weight(2f).padding(end = 2.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${currentData.feelsLikeC}°C",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.data2_temp_prom),
                    modifier = Modifier.weight(2f).padding(end = 2.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${forecastDayData.avgTempC}°C",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.data2_prob_lluvia),
                    modifier = Modifier.weight(2f).padding(end = 2.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${forecastDayData.dailyChanceOfRain}%",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.data2_prob_nieve),
                    modifier = Modifier.weight(2f).padding(end = 2.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${forecastDayData.dailyChanceOfSnow}%",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

        }
    }
}
