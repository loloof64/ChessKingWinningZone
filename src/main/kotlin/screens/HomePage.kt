package screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import i18n.LocalStrings

@Composable
fun HomePage(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(strings.homePageTitle)
                })
        }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
            Button(onClick = {
                navController.navigate(Screens.Game.name)
            }) {
                Text(strings.newGame)
            }
        }
    }
}