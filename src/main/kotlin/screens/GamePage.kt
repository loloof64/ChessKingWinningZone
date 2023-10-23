package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.ChessBoard
import components.emptyCell
import i18n.LocalStrings

@Composable
fun GamePage(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current
    var piecesValues by rememberSaveable { mutableStateOf(List(8) { List(8) { emptyCell} }) }
    var isWhiteTurn by rememberSaveable{ mutableStateOf(true) }
    var reversed by rememberSaveable{ mutableStateOf(false) }

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
                ChessBoard(
                    piecesValues = piecesValues,
                    isWhiteTurn = isWhiteTurn,
                    reversed = reversed
                )
            }
        }
    }
}