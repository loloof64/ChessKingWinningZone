package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import i18n.LocalStrings

@Composable
fun GamePage(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(strings.gamePageTitle)
                })
        }
    ) {
        Surface(
            modifier = modifier.background(color = MaterialTheme.colors.background)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
                Text("You're done !")
            }
        }
    }
}