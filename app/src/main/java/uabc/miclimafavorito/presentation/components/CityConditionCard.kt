package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import uabc.miclimafavorito.data.weather.Current
import uabc.miclimafavorito.R
import uabc.miclimafavorito.backend.components.getIconUrl

@Composable
fun CityConditionCard(
    modifier: Modifier = Modifier,
    currentData: Current,
    maxTempC: Double,
    minTempC: Double,
    contentColor: Color
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.temp, currentData.tempC),
                style = MaterialTheme.typography.displayMedium,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${currentData.condition.description}    ${maxTempC}°C / ${minTempC}°C",
                style = MaterialTheme.typography.titleMedium,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(5.dp))
            AsyncImage(
                model = getIconUrl(
                    url     = currentData.condition.icon,
                    isDay   = currentData.isDay
                ),
                contentDescription = "Ícono del clima",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}
