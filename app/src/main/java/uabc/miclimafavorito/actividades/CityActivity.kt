package uabc.miclimafavorito.actividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import uabc.miclimafavorito.ui.theme.MiClimaFavoritoTheme

/*
* Vista en donde se mostrará información de la ciudad
* y dará la opción para agregar o eliminar de favoritos,
* */
class CityActivity : ComponentActivity() {
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