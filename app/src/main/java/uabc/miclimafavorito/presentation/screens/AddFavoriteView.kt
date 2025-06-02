package uabc.miclimafavorito.presentation.screens

import android.content.Intent
import android.util.Log
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.R
import uabc.miclimafavorito.presentation.components.AppTopBar
import uabc.miclimafavorito.data.city.CityResponse
import uabc.miclimafavorito.presentation.components.FavoriteCityCard
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import uabc.miclimafavorito.backend.apiService.WeatherViewModel
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.platform.LocalContext
import uabc.miclimafavorito.actividades.CityActivity
import uabc.miclimafavorito.backend.database.CityViewModel
import uabc.miclimafavorito.data.city.City
import uabc.miclimafavorito.presentation.components.SwipeItem
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.text.style.TextAlign
import uabc.miclimafavorito.data.weather.SearchResponse

@Composable
fun AddFavoriteView(
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel = viewModel()
) {
    val context = LocalContext.current

    val activity = LocalActivity.current
    var cityInput by remember { mutableStateOf("") }
    var lastInput by remember { mutableStateOf("") }

    var isLoading by remember { mutableStateOf(false) }

    // Lista de ejemplo vacía por ahora, puedes vincular a tu ViewModel más adelante
    var searchResults by remember { mutableStateOf(listOf<CityResponse>()) }
    val citiesState by weatherViewModel.citiesState.collectAsState()
    var previousSearch by remember { mutableStateOf<List<SearchResponse>>(emptyList()) }

    LaunchedEffect(citiesState) {
        if (citiesState != previousSearch) {
            Log.d("AddFavoriteView", "results = '$citiesState'")

            previousSearch = citiesState
            val results = mutableListOf<CityResponse>()

            if(citiesState[0].id != 0L) {
                for (citySearched in citiesState) {
                    val weatherData = weatherViewModel.getWeatherSuspend(citySearched.id)
                    results.add(
                        CityResponse(
                            name = weatherData.location.name,
                            region = weatherData.location.region,
                            country = weatherData.location.country,
                            id = citySearched.id,
                            current = weatherData.current
                        )
                    )
                }
            }

            searchResults = results
            lastInput = cityInput
            cityInput = ""
            isLoading = false
        }
    }

    val cityViewModel: CityViewModel = viewModel()
    fun onSwipe(cityResponse: CityResponse) {
        val city = City(
            name = cityResponse.name,
            idCiudad = cityResponse.id,
        )
        cityViewModel.insertCity(city)
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.add_city),
                onBackClick = { activity?.finish() },
                isMain = false
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = cityInput,
                    onValueChange = { cityInput = it },
                    label = { Text("Buscar ciudad") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )

                Button(
                    onClick = {
                        isLoading = true
                        if (lastInput == cityInput){
                            isLoading = false
                        }
                        else{
                            weatherViewModel.getCities(cityInput)
                        }
                    },
                    modifier = Modifier,
                    enabled = !isLoading
                ) {

                    if(isLoading){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(24.dp), // Tamaño compacto
                        )
                    }
                    else{
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar"
                        )
                    }
                }

            }

            if(searchResults.isEmpty()){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sin datos",
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
            else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(searchResults) { city ->
                        SwipeItem(
                            modifier = Modifier,
                            swipeIcon = Icons.Default.Favorite,
                            swipeColor = MaterialTheme.colorScheme.primaryContainer,
                            swipeAction = {
                                onSwipe(city)
                            },
                            content = {
                                FavoriteCityCard(
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
    }
}
