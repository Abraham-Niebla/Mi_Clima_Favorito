package uabc.miclimafavorito.presentation.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.WeatherResponse
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import uabc.miclimafavorito.presentation.components.AppTopBar
import uabc.miclimafavorito.presentation.components.ForecastColumnData
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAddView(
    modifier: Modifier = Modifier,
    weather: WeatherResponse,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit = {}
) {
    val activity = LocalActivity.current
    val context = LocalContext.current // Get the current context

    Scaffold(
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
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            // Determine the query for Google Maps
                            val locationQuery =
                                "${weather.location.name}, ${weather.location.region}, ${weather.location.country}"
                            val gmmIntentUri = Uri.parse("geo:0,0?q=$locationQuery")
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                            mapIntent.setPackage("com.google.android.apps.maps") // Specify Google Maps package
                            if (mapIntent.resolveActivity(context.packageManager) != null) {
                                context.startActivity(mapIntent)
                            } else {
                                // If Google Maps app is not installed, open in a browser
                                val webIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$locationQuery")
                                val webIntent = Intent(Intent.ACTION_VIEW, webIntentUri)
                                context.startActivity(webIntent)
                            }
                        }
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
                            tint = MaterialTheme.colorScheme.primaryContainer,
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
                LazyRow(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(weather.forecast.forecastDay) { forecastDay ->
                        ForecastColumnData(
                            forecast = forecastDay,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}
