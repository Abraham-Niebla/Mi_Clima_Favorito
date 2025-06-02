package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.Location

@Composable
fun CityLocationCard(
    modifier: Modifier = Modifier,
    locationData: Location,
    contentColor: androidx.compose.ui.graphics.Color,
    onClick: (String) -> Unit // Modified to accept a String for the location query
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                // Determine the query for Google Maps
                val locationQuery = "${locationData.name}, ${locationData.region}, ${locationData.country}"
                onClick(locationQuery)
            }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location Pin",
                tint = contentColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = locationData.name,
                style = MaterialTheme.typography.headlineMedium,
                color = contentColor
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${locationData.region}, ${locationData.country}",
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
    }
}