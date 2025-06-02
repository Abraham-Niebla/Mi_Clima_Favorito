package uabc.miclimafavorito.actividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.backend.database.CityViewModel
import uabc.miclimafavorito.presentation.screens.CityAddScreen
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme

/*
* Vista en donde se mostrará información de la ciudad
* y dará la opción para agregar o eliminar de favoritos,
* */
class CityActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cityId = intent.getLongExtra("city_id", 0)
        val cityViewModel: CityViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            MiClimaFavoritoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CityAddScreen(
                        modifier = Modifier.padding(innerPadding),
                        cityId = cityId,
                        cityViewModel = cityViewModel
                    )
                }
            }
        }
    }
}
