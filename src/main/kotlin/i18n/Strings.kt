package i18n

import androidx.compose.runtime.staticCompositionLocalOf

data class Strings(
    val validate: String,
    val cancel: String,
    val homePageTitle: String,
    val gamePageTitle: String,
    val goBack: String,
    val swapBoardOrientation: String,
    val close: String,
    val queenPromotion: String,
    val rookPromotion: String,
    val bishopPromotion: String,
    val knightPromotion: String,
    val emptyCell: String,
    val whitePawn: String,
    val whiteKnight: String,
    val whiteBishop: String,
    val whiteRook: String,
    val whiteQueen: String,
    val whiteKing: String,
    val blackPawn: String,
    val blackKnight: String,
    val blackBishop: String,
    val blackRook: String,
    val blackQueen: String,
    val blackKing: String,
    val newGame: String,
    val reverseBoard: String,
)

val strings = mapOf(
    "en" to enStrings,
    "fr" to frStrings,
    "es" to esStrings,
)

val LocalStrings = staticCompositionLocalOf { enStrings }