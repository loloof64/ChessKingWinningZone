package components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import i18n.LocalStrings
import i18n.Strings
import logic.Cell
import logic.CellFile
import logic.CellRank
import logic.SelectedCells

const val emptyCell = ' '

@Composable
fun ChessBoard(
    piecesValues: List<List<Char>>,
    isWhiteTurn: Boolean,
    reversed: Boolean,
    selectedCellsSerialized: String,
    onCellClicked: (CellFile, CellRank) -> Unit = { _, _ -> }
) {
    val bgColor = Color(0xFF9999FF)
    BoxWithConstraints {
        val heightBasedAspectRatio = maxHeight > maxWidth
        val minAvailableSide = if (maxWidth < maxHeight) maxWidth else maxHeight
        val cellSize = minAvailableSide * 0.11f

        Box(
            modifier = Modifier.aspectRatio(1f, heightBasedAspectRatio).background(bgColor)
        ) {
            LowerLayer(
                cellSize = cellSize,
                reversed = reversed,
                piecesValues = piecesValues,
                isWhiteTurn = isWhiteTurn,
                selectedCellsSerialized = selectedCellsSerialized,
                onCellClicked = onCellClicked,
            )
        }
    }
}

@Composable
private fun LowerLayer(
    cellSize: Dp,
    reversed: Boolean,
    piecesValues: List<List<Char>>,
    isWhiteTurn: Boolean,
    selectedCellsSerialized: String,
    onCellClicked: (CellFile, CellRank) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ChessBoardHorizontalLabels(cellSize = cellSize, whiteTurn = null, reversed = reversed)
        (0..7).forEach { rowIndex ->
            val rank = if (reversed) rowIndex + 1 else 8 - rowIndex
            val rankLabel = "${Char('0'.code + rank)}"
            val firstIsWhite = rowIndex % 2 == 0
            val rowPiecesValues = piecesValues[if (reversed) 7 - rowIndex else rowIndex]
            ChessBoardCellsLine(
                cellSize = cellSize, firstCellWhite = firstIsWhite,
                rankLabel = rankLabel, rowPiecesValues = rowPiecesValues,
                reversed = reversed, onCellClicked = onCellClicked,
                selectedCellsSerialized = selectedCellsSerialized, rowIndex = rowIndex,
            )
        }
        ChessBoardHorizontalLabels(cellSize = cellSize, whiteTurn = isWhiteTurn, reversed = reversed)
    }
}

@Composable
private fun ChessBoardCellsLine(
    cellSize: Dp,
    firstCellWhite: Boolean,
    rankLabel: String,
    rowPiecesValues: List<Char>,
    reversed: Boolean,
    rowIndex: Int,
    selectedCellsSerialized: String,
    onCellClicked: (CellFile, CellRank) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val selectedCells = SelectedCells.fromSerialized(selectedCellsSerialized).values


        ChessBoardVerticalLabel(text = rankLabel, cellSize = cellSize)
        (0..7).forEach { colIndex ->
            val cellFile = CellFile.values()[if (reversed) 7 - colIndex else colIndex]
            val cellRank = CellRank.values()[if (reversed) rowIndex else 7 - rowIndex]
            ChessBoardCell(
                isWhite = if ((colIndex % 2) == 0) firstCellWhite else !firstCellWhite,
                size = cellSize,
                pieceValue = rowPiecesValues[if (reversed) 7 - colIndex else colIndex],
                onCellClicked = onCellClicked,
                file = cellFile,
                rank = cellRank,
                isSelected = selectedCells.contains(Cell(file = cellFile, rank = cellRank))
            )
        }
        ChessBoardVerticalLabel(text = rankLabel, cellSize = cellSize)
    }
}

@Composable
private fun ChessBoardVerticalLabel(
    modifier: Modifier = Modifier, text: String, cellSize: Dp
) {
    val fontSize = with(LocalDensity.current) {
        (cellSize * 0.3f).toSp()
    }
    Column(
        modifier = modifier.width(cellSize / 2).height(cellSize / 2).background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text, fontWeight = FontWeight.Bold, color = Color.Yellow, fontSize = fontSize)
    }
}

@Composable
private fun ChessBoardHorizontalLabels(
    modifier: Modifier = Modifier, cellSize: Dp, whiteTurn: Boolean?, reversed: Boolean
) {
    val fontSize = with(LocalDensity.current) {
        (cellSize * 0.3f).toSp()
    }
    Row(
        modifier = modifier.fillMaxWidth().height(cellSize / 2)
    ) {
        Row(
            modifier = Modifier.width(cellSize / 2).height(cellSize / 2)
        ) {
            Text(
                text = "", fontWeight = FontWeight.Bold, color = Color.Transparent, fontSize = fontSize
            )
        }
        (0..7).forEach {
            val col = if (reversed) 7 - it else it
            val colLabel = "${Char('A'.code + col)}"
            Row(
                modifier = Modifier.width(cellSize).height(cellSize / 2),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = colLabel,
                    fontWeight = FontWeight.Bold,
                    color = Color.Yellow,
                    fontSize = fontSize,
                    textAlign = TextAlign.Center,
                )
            }
        }
        if (whiteTurn == null) {
            Row(
                modifier = Modifier.width(cellSize / 2).height(cellSize / 2)
            ) {
                Text(
                    text = "", fontWeight = FontWeight.Bold, color = Color.Transparent, fontSize = fontSize
                )
            }
        } else {
            val color = if (whiteTurn) Color.White else Color.Black
            Column(
                modifier = Modifier.width(cellSize / 2).height(cellSize / 2).clip(CircleShape).background(color)
            ) {

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ChessBoardCell(
    modifier: Modifier = Modifier,
    isWhite: Boolean,
    size: Dp,
    pieceValue: Char,
    file: CellFile,
    rank: CellRank,
    isSelected: Boolean,
    onCellClicked: (CellFile, CellRank) -> Unit,
) {
    val whiteCellColor = 0xFFFFDEAD
    val blackCellColor = 0xFFCD853F
    val selectedColor = 0XFF2EFE9A

    val strings = LocalStrings.current
    var bgColor = if (isWhite) Color(whiteCellColor) else Color(blackCellColor)
    if (isSelected) bgColor = Color(selectedColor)

    Surface(modifier = modifier.size(size).onClick {
        onCellClicked(file, rank)
    }) {
        Column(modifier = Modifier.background(bgColor)) {
            val noPiece = pieceValue == emptyCell
            if (!noPiece) {
                Image(
                    painter = painterResource(getVectorForPiece(pieceValue)),
                    contentDescription = getContentDescriptionForPiece(pieceValue, strings),
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}

fun getVectorForPiece(pieceValue: Char): String {
    val name = when (pieceValue) {
        'P' -> "Chess_plt45.svg"
        'N' -> "Chess_nlt45.svg"
        'B' -> "Chess_blt45.svg"
        'R' -> "Chess_rlt45.svg"
        'Q' -> "Chess_qlt45.svg"
        'K' -> "Chess_klt45.svg"

        'p' -> "Chess_pdt45.svg"
        'n' -> "Chess_ndt45.svg"
        'b' -> "Chess_bdt45.svg"
        'r' -> "Chess_rdt45.svg"
        'q' -> "Chess_qdt45.svg"
        'k' -> "Chess_kdt45.svg"
        else -> throw IllegalArgumentException("Not recognized piece $pieceValue")
    }
    return "images/chess_vectors/$name"
}

fun getContentDescriptionForPiece(pieceValue: Char, strings: Strings): String {
    return when (pieceValue) {
        'P' -> strings.whitePawn
        'N' -> strings.whiteKnight
        'B' -> strings.whiteBishop
        'R' -> strings.whiteRook
        'Q' -> strings.whiteQueen
        'K' -> strings.whiteKing

        'p' -> strings.blackPawn
        'n' -> strings.blackKnight
        'b' -> strings.blackBishop
        'r' -> strings.blackRook
        'q' -> strings.blackQueen
        'k' -> strings.blackKing
        else -> strings.emptyCell
    }
}