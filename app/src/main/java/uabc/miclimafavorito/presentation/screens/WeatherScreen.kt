package uabc.miclimafavorito.presentation.screens

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uabc.miclimafavorito.backend.apiService.WeatherViewModel
import androidx.compose.material3.Scaffold
import androidx.activity.compose.LocalActivity
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.presentation.components.AppTopBar
import uabc.miclimafavorito.R
import uabc.miclimafavorito.actividades.FavoritesActivity
import uabc.miclimafavorito.data.weather.WeatherResponse
import uabc.miclimafavorito.presentation.components.CityPager

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = viewModel(),
    cityData: List<WeatherResponse>
) {
    val activity = LocalActivity.current

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.weather_title),  // define este string en strings.xml
                onBackClick = {
                    activity?.let {
                        val intent = Intent(it, FavoritesActivity::class.java)
                        it.startActivity(intent)
                    }
                },
                isMain = true
            )
        }
    ) { paddingValues ->

        CityPager(
            modifier = Modifier.padding(paddingValues),
            cityData = cityData
        )
    }
}
