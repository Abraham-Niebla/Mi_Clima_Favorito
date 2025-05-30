package uabc.miclimafavorito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.presentation.screens.WeatherScreen
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme

/*
* Vista inicial
* Se mostrará el estado actual del clima,
* así como el pronóstico del mismo día y los siguientes tres días.
* Esto lo hará para cada una de las ciudades favoritas.
* */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiClimaFavoritoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
