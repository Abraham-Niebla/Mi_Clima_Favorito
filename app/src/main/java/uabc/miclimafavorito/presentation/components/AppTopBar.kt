package uabc.miclimafavorito.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import uabc.miclimafavorito.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AppTopBar(
    title: String,
    onBackClick: () -> Unit,
    isMain: Boolean,
) {
    val backgroundColor: Color  = Color.Transparent
    val contentColor: Color     = MaterialTheme.colorScheme.primary

    TopAppBar(
        title = { Text(text = title, color = contentColor) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                if (isMain) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = stringResource(R.string.page_favorites),
                        tint = contentColor
                    )
                } else {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.page_return),
                        tint = contentColor
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = contentColor,
            navigationIconContentColor = contentColor
        )
    )
}
