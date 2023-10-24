package screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.navigator.Navigator


@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val lyricist = rememberStrings()
    ProvideStrings(lyricist) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Navigator(Home())
        }
    }
}