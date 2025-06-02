package uabc.miclimafavorito.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import uabc.miclimafavorito.globals.ROUND_BORDERS_VALUE


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SwipeItem(
    modifier: Modifier = Modifier,
    swipeAction: () -> Unit = {},
    swipeIcon: ImageVector,
    swipeColor: Color,
    swipeIconColor: Color,
    content: @Composable () -> Unit
) {

    // 1. State is hoisted here
    val dismissState = rememberSwipeToDismissBoxState()

    SwipeToDismissBox(
        modifier = modifier,
        state = dismissState,
        backgroundContent = {

            // 2. Animate the swipe by changing the color
            val color by animateColorAsState(
                targetValue = when (dismissState.targetValue) {
                    SwipeToDismissBoxValue.Settled      -> Color.Transparent
                    SwipeToDismissBoxValue.StartToEnd   -> swipeColor
                    SwipeToDismissBoxValue.EndToStart   -> swipeColor
                },
                label = "swipe"
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(ROUND_BORDERS_VALUE))
                    .background(color) // 3. Set the animated color here
            ) {

                // 4. Show the correct icon
                when (dismissState.targetValue) {
                    SwipeToDismissBoxValue.StartToEnd -> {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 16.dp),
                            imageVector = swipeIcon,
                            tint = swipeIconColor,
                            contentDescription = null
                        )
                    }

                    SwipeToDismissBoxValue.EndToStart -> {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp),
                            imageVector = swipeIcon,
                            tint = swipeIconColor,
                            contentDescription = null,
                        )
                    }

                    SwipeToDismissBoxValue.Settled -> {
                        // Nothing to do
                    }
                }

            }
        }
    ) {
        content()
    }

    // 5. Trigger the callbacks
    when (dismissState.currentValue) {
        SwipeToDismissBoxValue.EndToStart -> {
            LaunchedEffect(dismissState.currentValue) {
                swipeAction()

                // 6. Don't forget to reset the state value
                dismissState.snapTo(SwipeToDismissBoxValue.Settled) // or dismissState.reset()
            }

        }

        SwipeToDismissBoxValue.StartToEnd -> {
            LaunchedEffect(dismissState.currentValue) {
                swipeAction()
                dismissState.snapTo(SwipeToDismissBoxValue.Settled) // or dismissState.reset()
            }
        }

        SwipeToDismissBoxValue.Settled -> {
            // Nothing to do
        }
    }
}