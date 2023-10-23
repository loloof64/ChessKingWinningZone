package screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier


@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val navController by rememberNavController(Screens.Home.name)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // This is how you can use
        CustomNavigationHost(navController = navController)

    }
}