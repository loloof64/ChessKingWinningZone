package logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import components.*
import io.github.wolfraam.chessgame.ChessGame
import io.github.wolfraam.chessgame.board.Piece
import io.github.wolfraam.chessgame.board.PieceType
import io.github.wolfraam.chessgame.board.Side
import io.github.wolfraam.chessgame.board.Square
import io.github.wolfraam.chessgame.move.IllegalMoveException
import io.github.wolfraam.chessgame.move.Move
import io.github.wolfraam.chessgame.notation.NotationType
import io.github.wolfraam.chessgame.pgn.PGNExporter
import io.github.wolfraam.chessgame.pgn.PgnTag
import io.github.wolfraam.chessgame.result.ChessGameResult
import io.github.wolfraam.chessgame.result.ChessGameResultType
import io.github.wolfraam.chessgame.result.DrawType
import java.io.File
import java.io.FileOutputStream

const val defaultPosition = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
const val emptyPosition = "4k3/8/8/8/8/8/8/4K3 w - - 0 1"