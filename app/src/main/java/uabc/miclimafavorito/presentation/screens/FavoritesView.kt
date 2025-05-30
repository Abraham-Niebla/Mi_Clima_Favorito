package uabc.miclimafavorito.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.R
import uabc.miclimafavorito.presentation.components.AppTopBar
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.presentation.components.FavoriteCityCard

@Composable
fun FavoritesView(
    modifier: Modifier = Modifier,
    cityData: List<CityResponse>
) {
    val activity = LocalActivity.current

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.favorites_title),
                onBackClick = { activity?.finish() },
                isMain = false
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            items(cityData) { city ->
                FavoriteCityCard(
                    modifier = Modifier,
                    cityData = city
                )
            }
        }
    }
}
