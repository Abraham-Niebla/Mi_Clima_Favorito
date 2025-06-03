package uabc.miclimafavorito.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.data.city.CityResponse

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    cityData: List<CityResponse>,
    onSwipe: (CityResponse) -> Unit
) {
    val isLoading = cityData.any {
        it.current.lastUpdated.isBlank() || it.current.tempC == 0.0
    }

    if (isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        FavoritesView(
            modifier = modifier,
            cityData = cityData,
            onSwipe = onSwipe
        )
    }
}
