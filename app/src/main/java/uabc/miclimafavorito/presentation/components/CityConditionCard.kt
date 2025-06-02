package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import uabc.miclimafavorito.data.weather.Forecast

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
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.temp, currentData.tempC),
                style = MaterialTheme.typography.displayLarge,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${currentData.condition.description} ${maxTempC}/${minTempC}",
                style = MaterialTheme.typography.titleMedium,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = getIconUrl(
                    url     = currentData.condition.icon,
                    isDay   = currentData.isDay
                ),
                contentDescription = "Ícono del clima",
                modifier = Modifier
                    .size(64.dp)
            )
        }
    }
}
