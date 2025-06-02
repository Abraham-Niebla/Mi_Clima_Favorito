package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.Location

@Composable
fun CityLocationCard(
    modifier: Modifier = Modifier,
    locationData: Location,
    onClick: () -> Unit,
    contentColor: Color
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
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
                text = locationData.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "${locationData.region}, ${locationData.country}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
