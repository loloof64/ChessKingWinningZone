package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.lyricist.LocalStrings
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current
    val navigator = LocalNavigator.currentOrThrow

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(strings.homePageTitle)
                })
        }
    ) {
        Surface(
            modifier = modifier.background(color = MaterialTheme.colors.background)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
                Button(onClick = {
                    navigator.push(Game())
                }) {
                    Text(strings.newGame)
                }
            }
        }
    }
}
