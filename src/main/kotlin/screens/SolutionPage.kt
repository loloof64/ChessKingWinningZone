package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import components.ChessBoard
import i18n.LocalStrings
import logic.Exercise
import logic.Solution
import logic.generateExercise

@Composable
fun SolutionPage(
    exercise: Exercise,
    solution: Solution,
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current
    val isWhiteTurn by rememberSaveable { mutableStateOf(exercise.isWhiteTurn) }
    var reversed by rememberSaveable { mutableStateOf(!exercise.isWhiteTurn) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(strings.solutionPageTitle)
                }, actions = {
                    IconButton(onClick = {
                        reversed = !reversed
                    }) {
                        Image(
                            painter = painterResource("images/material_vectors/swap_vert.svg"),
                            contentDescription = strings.reverseBoard,
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                })
        }
    ) {
        Surface(
            modifier = modifier.background(color = MaterialTheme.colors.background)
        ) {
            Box(contentAlignment = Alignment.CenterStart, modifier = modifier.fillMaxSize()) {
                ChessBoard(
                    piecesValues = exercise.pieces,
                    isWhiteTurn = isWhiteTurn,
                    reversed = reversed,
                    selectedCellsSerialized = "",
                    onCellClicked = { _, _ ->

                    }
                )
            }
        }
    }
}