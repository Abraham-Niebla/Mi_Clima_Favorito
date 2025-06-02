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
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.Current
import uabc.miclimafavorito.backend.components.getWindDir
import uabc.miclimafavorito.backend.components.windDirToDegrees

@Composable
fun CityWindCard(
    modifier: Modifier = Modifier,
    currentData: Current,
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Textos: 2/3 del ancho
            Column(
                modifier = Modifier
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = getWindDir(currentData.windDir),
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${currentData.windKph}km/h",
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor
                )
            }

            // Flecha: 1/3 del ancho, centrada vertical y horizontalmente
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                WindDirectionArrow(
                    windDegree = windDirToDegrees(currentData.windDir),
                    modifier = Modifier.size(50.dp),
                    arrowColor = contentColor,
                    size = 50.dp
                )
            }
        }
    }
}
