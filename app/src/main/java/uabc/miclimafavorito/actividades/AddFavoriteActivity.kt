package uabc.miclimafavorito.actividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme

/*
* Vista en donde se podrán buscar las ciudades para agregarlas a favoritas,
* si la búsqueda no arroja nada, se indicará que no hay resultados
* */
class AddFavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val intent = intent
//        val maxScore = intent.getIntExtra("maxScore", 0)

        enableEdgeToEdge()
        setContent {
            MiClimaFavoritoTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ChangeScoreView(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .fillMaxSize(),
//                        maxScore = maxScore,
//                        maxTiros = maxTiros
//                    )
//                }
            }
        }
    }
}