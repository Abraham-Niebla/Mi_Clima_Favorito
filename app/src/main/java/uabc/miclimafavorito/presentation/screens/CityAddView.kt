package uabc.miclimafavorito.presentation.screens

import android.os.Build
import android.util.Log
import androidx.activity.compose.LocalActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.WeatherResponse
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import uabc.miclimafavorito.presentation.components.AppTopBar
import uabc.miclimafavorito.presentation.components.ColumnData
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAddView(
    modifier: Modifier = Modifier,
    weather: WeatherResponse,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit = {}
) {
    val activity = LocalActivity.current

    Scaffold(
        modifier = modifier,
        topBar = {
            AppTopBar(
                title = "",
                onBackClick = { activity?.finish() },
                isMain = false
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)  // para no tapar contenido bajo la barra
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = weather.location.name,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "${weather.location.region}, ${weather.location.country}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .height(72.dp)
                        .aspectRatio(1f)
                ) {
                    if (isFavorite) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favorito",
                            tint = MaterialTheme.colorScheme.tertiaryContainer,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "No favorito",
                            tint = MaterialTheme.colorScheme.inverseSurface,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Resto del contenido sin cambios...
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors()
            ) {
                Log.d("CityAddView", "Número de días: ${weather.forecast.forecastDay.size}")
                LazyRow(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(weather.forecast.forecastDay) { forecastDay ->
                        Log.d("forecastDay", "$forecastDay")
                        ColumnData(
                            forecast = forecastDay,
                            modifier = Modifier.width(120.dp)
                        )
                    }

                }
            }
        }
    }
}
