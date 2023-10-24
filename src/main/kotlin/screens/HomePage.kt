package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.lyricist.LocalStrings
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import logic.generateExercise

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current
    val navigator = LocalNavigator.currentOrThrow
    var showProgressBar by rememberSaveable{ mutableStateOf(false) }

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
                val scope = rememberCoroutineScope()
                Button(onClick = {
                    scope.launch(Dispatchers.IO) {
                        showProgressBar = true
                        val exercise = generateExercise()
                        showProgressBar = false
                        navigator.push(Game(exercise = exercise))
                    }
                }) {
                    Text(strings.newGame)
                }
                if (showProgressBar) {
                    CircularProgressIndicator(modifier= Modifier.size(40.dp))
                }
            }
        }
    }
}
