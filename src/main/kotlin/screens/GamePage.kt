package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import components.ChessBoard
import i18n.LocalStrings
import logic.Cell
import logic.generateExercise

class SelectedCells(val selectedCells: List<Cell> = listOf()) {

    val serialized: String
        get() =
            selectedCells.joinToString(separator = "|") {
                it.asciiValue()
            }

    fun toggleCell(cell: Cell): SelectedCells {
        val newCellsValues = selectedCells.toMutableList()
        if (selectedCells.contains(cell)) {
            newCellsValues.remove(cell)
        } else {
            newCellsValues.add(cell)
        }
        return SelectedCells(newCellsValues)
    }

    companion object {
        fun fromSerialized(string: String): SelectedCells {
            val newCellsValues = if (string.isEmpty()) listOf() else string.split('|').map { serialized ->
                Cell.fromAscii(serialized)
            }
            return SelectedCells(newCellsValues)
        }

        val saver = Saver<SelectedCells, String>(
            save = { it.serialized },
            restore = { fromSerialized(it) }
        )
    }
}

@Composable
fun GamePage(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val strings = LocalStrings.current
    val exercise by rememberSaveable { mutableStateOf(generateExercise()) }
    val isWhiteTurn by rememberSaveable { mutableStateOf(exercise.isWhiteTurn) }
    var reversed by rememberSaveable { mutableStateOf(!exercise.isWhiteTurn) }
    var selectedCells = rememberSaveable(saver = SelectedCells.saver) { SelectedCells() }
    var selectedCellsSerialized by remember { mutableStateOf(selectedCells.serialized) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(strings.gamePageTitle)
                }, actions = {
                    IconButton(onClick = {
                        reversed = !reversed
                    }) {
                        Image(
                            painter = painterResource("images/material_vectors/swap_vert.svg"),
                            contentDescription = strings.reverseBoard,
                            modifier = Modifier.size(30.dp),
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                        )
                    }
                })
        }
    ) {
        Surface(
            modifier = modifier.background(color = MaterialTheme.colors.background)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
                ChessBoard(
                    piecesValues = exercise.pieces,
                    isWhiteTurn = isWhiteTurn,
                    reversed = reversed,
                    selectedCellsSerialized = selectedCellsSerialized,
                    onCellClicked = { file, rank ->
                        val clickedCell = Cell(file = file, rank = rank)
                        selectedCells = selectedCells.toggleCell(clickedCell)
                        selectedCellsSerialized = selectedCells.serialized
                    }
                )
            }
        }
    }
}