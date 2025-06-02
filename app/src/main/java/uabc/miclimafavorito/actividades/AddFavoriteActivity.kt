package uabc.miclimafavorito.actividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.presentation.screens.AddFavoriteView
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme

/*
* Vista en donde se podrán buscar las ciudades para agregarlas a favoritas,
* si la búsqueda no arroja nada, se indicará que no hay resultados
* */
class AddFavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiClimaFavoritoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AddFavoriteView(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}