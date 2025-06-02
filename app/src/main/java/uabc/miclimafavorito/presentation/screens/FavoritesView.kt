package uabc.miclimafavorito.presentation.screens

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.R
import uabc.miclimafavorito.presentation.components.AppTopBar
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.actividades.AddFavoriteActivity
import uabc.miclimafavorito.actividades.CityActivity
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.presentation.components.FavoriteCityCard
import uabc.miclimafavorito.presentation.components.SwipeItem


@Composable
fun FavoritesView(
    modifier: Modifier = Modifier,
    cityData: List<CityResponse>,
    onSwipe: (CityResponse) -> Unit
) {
    val activity = LocalActivity.current
    val context = LocalContext.current

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.favorites_title),
                onBackClick = { activity?.finish() },
                isMain = false
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    activity?.let {
                        val intent = Intent(it, AddFavoriteActivity::class.java)
                        it.startActivity(intent)
                    }
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_city)
                )
            }
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(cityData) { city ->

                SwipeItem(
                    modifier = Modifier,
                    swipeIcon = Icons.Default.Delete,
                    swipeColor = MaterialTheme.colorScheme.secondaryContainer,
                    swipeAction = {
                        onSwipe(city)
                    },
                    content = {
                        FavoriteCityCard(
                            modifier = Modifier,
                            cityData = city,
                            onClick = {
                                val intent = Intent(context, CityActivity::class.java).apply {
                                    putExtra("city_id", city.id)
                                }
                                context.startActivity(intent)
                            }
                        )
                    },
                )
            }
        }
    }

}
