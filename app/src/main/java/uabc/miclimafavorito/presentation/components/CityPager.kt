package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.data.weather.WeatherResponse

@Composable
fun CityPager(
    modifier: Modifier = Modifier,
    cityData: List<WeatherResponse>
) {
    val pagerState = rememberPagerState { cityData.size }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // 🟣 Indicador de página con puntos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(cityData.size) { index ->
                val isSelected = pagerState.currentPage == index

                Icon(
                    imageVector = Icons.Default.Circle,
                    contentDescription = null,
                    tint =  if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.inverseSurface, // Color más visible
                    modifier = Modifier
                        .size(if (isSelected) 16.dp else 12.dp)
                        .padding(horizontal = 4.dp)
                )

            }
        }

        // 📱 Pager de ciudades
        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { pageIndex ->
            val city = cityData[pageIndex]
            CityCard(city = city)
        }
    }
}
