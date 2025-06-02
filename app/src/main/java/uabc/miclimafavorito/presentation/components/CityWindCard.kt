package uabc.miclimafavorito.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uabc.miclimafavorito.data.weather.Current
import uabc.miclimafavorito.R
import uabc.miclimafavorito.backend.components.getWindDir

@Composable
fun CityWindCard(
    modifier: Modifier = Modifier,
    currentData: Current,
    contentColor: Color
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.1f),
            contentColor = contentColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Primera columna: textos
            Column(
                modifier = Modifier
                    .weight(3f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = getWindDir(currentData.windDir),
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${currentData.windKph}km/h",
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor
                )
            }

            // Segunda columna: imagen
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_wind), // reemplaza con tu recurso real
//                    contentDescription = "Ícono del viento",
//                    modifier = Modifier.size(48.dp),
//                    contentScale = ContentScale.Fit
//                )
            }
        }
    }
}
