package logic

import components.emptyCell
import kotlin.random.Random

enum class CellFile {
    FileA,
    FileB,
    FileC,
    FileD,
    FileE,
    FileF,
    FileG,
    FileH
}

enum class CellRank {
    Rank1,
    Rank2,
    Rank3,
    Rank4,
    Rank5,
    Rank6,
    Rank7,
    Rank8
}

enum class CompanionKingSide {
    NoImportant,
    InShortSide,
    InLongSide,
}

data class Cell(val file: CellFile, val rank: CellRank)

data class EnemyPawnConfiguration(val isWhiteSide: Boolean, val cell: Cell, val companionKingSide: CompanionKingSide)

val expectedCells = mapOf(
    EnemyPawnConfiguration(
        isWhiteSide = true,
        cell = Cell(file = CellFile.FileA, rank = CellRank.Rank7),
        companionKingSide = CompanionKingSide.NoImportant
    ) to listOf(
        Cell(file = CellFile.FileA, rank = CellRank.Rank8),
        Cell(file = CellFile.FileB, rank = CellRank.Rank8),
        Cell(file = CellFile.FileC, rank = CellRank.Rank8),
        Cell(file = CellFile.FileD, rank = CellRank.Rank8),
        Cell(file = CellFile.FileE, rank = CellRank.Rank8),

        Cell(file = CellFile.FileA, rank = CellRank.Rank7),
        Cell(file = CellFile.FileB, rank = CellRank.Rank7),
        Cell(file = CellFile.FileC, rank = CellRank.Rank7),
        Cell(file = CellFile.FileD, rank = CellRank.Rank7),
        Cell(file = CellFile.FileE, rank = CellRank.Rank7),

        Cell(file = CellFile.FileA, rank = CellRank.Rank6),
        Cell(file = CellFile.FileB, rank = CellRank.Rank6),
        Cell(file = CellFile.FileC, rank = CellRank.Rank6),
        Cell(file = CellFile.FileD, rank = CellRank.Rank6),
        Cell(file = CellFile.FileE, rank = CellRank.Rank6),

        Cell(file = CellFile.FileA, rank = CellRank.Rank5),
        Cell(file = CellFile.FileB, rank = CellRank.Rank5),
        Cell(file = CellFile.FileC, rank = CellRank.Rank5),
        Cell(file = CellFile.FileD, rank = CellRank.Rank5),
        Cell(file = CellFile.FileE, rank = CellRank.Rank5),

        Cell(file = CellFile.FileA, rank = CellRank.Rank4),
        Cell(file = CellFile.FileB, rank = CellRank.Rank4),
        Cell(file = CellFile.FileC, rank = CellRank.Rank4),
        Cell(file = CellFile.FileD, rank = CellRank.Rank4),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = true,
        cell = Cell(file = CellFile.FileH, rank = CellRank.Rank7),
        companionKingSide = CompanionKingSide.NoImportant
    ) to listOf(
        Cell(file = CellFile.FileH, rank = CellRank.Rank8),
        Cell(file = CellFile.FileG, rank = CellRank.Rank8),
        Cell(file = CellFile.FileF, rank = CellRank.Rank8),
        Cell(file = CellFile.FileE, rank = CellRank.Rank8),
        Cell(file = CellFile.FileD, rank = CellRank.Rank8),

        Cell(file = CellFile.FileH, rank = CellRank.Rank7),
        Cell(file = CellFile.FileG, rank = CellRank.Rank7),
        Cell(file = CellFile.FileF, rank = CellRank.Rank7),
        Cell(file = CellFile.FileE, rank = CellRank.Rank7),
        Cell(file = CellFile.FileD, rank = CellRank.Rank7),

        Cell(file = CellFile.FileH, rank = CellRank.Rank6),
        Cell(file = CellFile.FileG, rank = CellRank.Rank6),
        Cell(file = CellFile.FileF, rank = CellRank.Rank6),
        Cell(file = CellFile.FileE, rank = CellRank.Rank6),
        Cell(file = CellFile.FileD, rank = CellRank.Rank6),

        Cell(file = CellFile.FileH, rank = CellRank.Rank5),
        Cell(file = CellFile.FileG, rank = CellRank.Rank5),
        Cell(file = CellFile.FileF, rank = CellRank.Rank5),
        Cell(file = CellFile.FileE, rank = CellRank.Rank5),
        Cell(file = CellFile.FileD, rank = CellRank.Rank5),

        Cell(file = CellFile.FileH, rank = CellRank.Rank4),
        Cell(file = CellFile.FileG, rank = CellRank.Rank4),
        Cell(file = CellFile.FileF, rank = CellRank.Rank4),
        Cell(file = CellFile.FileE, rank = CellRank.Rank4),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = false,
        cell = Cell(file = CellFile.FileA, rank = CellRank.Rank2),
        companionKingSide = CompanionKingSide.NoImportant
    ) to listOf(
        Cell(file = CellFile.FileA, rank = CellRank.Rank1),
        Cell(file = CellFile.FileB, rank = CellRank.Rank1),
        Cell(file = CellFile.FileC, rank = CellRank.Rank1),
        Cell(file = CellFile.FileD, rank = CellRank.Rank1),
        Cell(file = CellFile.FileE, rank = CellRank.Rank1),

        Cell(file = CellFile.FileA, rank = CellRank.Rank2),
        Cell(file = CellFile.FileB, rank = CellRank.Rank2),
        Cell(file = CellFile.FileC, rank = CellRank.Rank2),
        Cell(file = CellFile.FileD, rank = CellRank.Rank2),
        Cell(file = CellFile.FileE, rank = CellRank.Rank2),

        Cell(file = CellFile.FileA, rank = CellRank.Rank3),
        Cell(file = CellFile.FileB, rank = CellRank.Rank3),
        Cell(file = CellFile.FileC, rank = CellRank.Rank3),
        Cell(file = CellFile.FileD, rank = CellRank.Rank3),
        Cell(file = CellFile.FileE, rank = CellRank.Rank3),

        Cell(file = CellFile.FileA, rank = CellRank.Rank4),
        Cell(file = CellFile.FileB, rank = CellRank.Rank4),
        Cell(file = CellFile.FileC, rank = CellRank.Rank4),
        Cell(file = CellFile.FileD, rank = CellRank.Rank4),
        Cell(file = CellFile.FileE, rank = CellRank.Rank4),

        Cell(file = CellFile.FileA, rank = CellRank.Rank5),
        Cell(file = CellFile.FileB, rank = CellRank.Rank5),
        Cell(file = CellFile.FileC, rank = CellRank.Rank5),
        Cell(file = CellFile.FileD, rank = CellRank.Rank5),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = false,
        cell = Cell(file = CellFile.FileH, rank = CellRank.Rank2),
        companionKingSide = CompanionKingSide.NoImportant
    ) to listOf(
        Cell(file = CellFile.FileH, rank = CellRank.Rank1),
        Cell(file = CellFile.FileG, rank = CellRank.Rank1),
        Cell(file = CellFile.FileF, rank = CellRank.Rank1),
        Cell(file = CellFile.FileE, rank = CellRank.Rank1),
        Cell(file = CellFile.FileD, rank = CellRank.Rank1),

        Cell(file = CellFile.FileH, rank = CellRank.Rank2),
        Cell(file = CellFile.FileG, rank = CellRank.Rank2),
        Cell(file = CellFile.FileF, rank = CellRank.Rank2),
        Cell(file = CellFile.FileE, rank = CellRank.Rank2),
        Cell(file = CellFile.FileD, rank = CellRank.Rank2),

        Cell(file = CellFile.FileH, rank = CellRank.Rank3),
        Cell(file = CellFile.FileG, rank = CellRank.Rank3),
        Cell(file = CellFile.FileF, rank = CellRank.Rank3),
        Cell(file = CellFile.FileE, rank = CellRank.Rank3),
        Cell(file = CellFile.FileD, rank = CellRank.Rank3),

        Cell(file = CellFile.FileH, rank = CellRank.Rank4),
        Cell(file = CellFile.FileG, rank = CellRank.Rank4),
        Cell(file = CellFile.FileF, rank = CellRank.Rank4),
        Cell(file = CellFile.FileE, rank = CellRank.Rank4),
        Cell(file = CellFile.FileD, rank = CellRank.Rank4),

        Cell(file = CellFile.FileH, rank = CellRank.Rank5),
        Cell(file = CellFile.FileG, rank = CellRank.Rank5),
        Cell(file = CellFile.FileF, rank = CellRank.Rank5),
        Cell(file = CellFile.FileE, rank = CellRank.Rank5),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = true,
        cell = Cell(file = CellFile.FileC, rank = CellRank.Rank7),
        companionKingSide = CompanionKingSide.InShortSide
    ) to listOf(
        Cell(file = CellFile.FileA, rank = CellRank.Rank8),
        Cell(file = CellFile.FileB, rank = CellRank.Rank8),
        Cell(file = CellFile.FileC, rank = CellRank.Rank8),
        Cell(file = CellFile.FileD, rank = CellRank.Rank8),
        Cell(file = CellFile.FileE, rank = CellRank.Rank8),

        Cell(file = CellFile.FileA, rank = CellRank.Rank7),
        Cell(file = CellFile.FileB, rank = CellRank.Rank7),
        Cell(file = CellFile.FileC, rank = CellRank.Rank7),
        Cell(file = CellFile.FileD, rank = CellRank.Rank7),
        Cell(file = CellFile.FileE, rank = CellRank.Rank7),

        Cell(file = CellFile.FileA, rank = CellRank.Rank6),
        Cell(file = CellFile.FileB, rank = CellRank.Rank6),
        Cell(file = CellFile.FileC, rank = CellRank.Rank6),
        Cell(file = CellFile.FileD, rank = CellRank.Rank6),
        Cell(file = CellFile.FileE, rank = CellRank.Rank6),

        Cell(file = CellFile.FileA, rank = CellRank.Rank5),
        Cell(file = CellFile.FileB, rank = CellRank.Rank5),
        Cell(file = CellFile.FileC, rank = CellRank.Rank5),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = true,
        cell = Cell(file = CellFile.FileF, rank = CellRank.Rank7),
        companionKingSide = CompanionKingSide.InShortSide
    ) to listOf(
        Cell(file = CellFile.FileH, rank = CellRank.Rank8),
        Cell(file = CellFile.FileG, rank = CellRank.Rank8),
        Cell(file = CellFile.FileF, rank = CellRank.Rank8),
        Cell(file = CellFile.FileE, rank = CellRank.Rank8),
        Cell(file = CellFile.FileD, rank = CellRank.Rank8),

        Cell(file = CellFile.FileH, rank = CellRank.Rank7),
        Cell(file = CellFile.FileG, rank = CellRank.Rank7),
        Cell(file = CellFile.FileF, rank = CellRank.Rank7),
        Cell(file = CellFile.FileE, rank = CellRank.Rank7),
        Cell(file = CellFile.FileD, rank = CellRank.Rank7),

        Cell(file = CellFile.FileH, rank = CellRank.Rank6),
        Cell(file = CellFile.FileG, rank = CellRank.Rank6),
        Cell(file = CellFile.FileF, rank = CellRank.Rank6),
        Cell(file = CellFile.FileE, rank = CellRank.Rank6),
        Cell(file = CellFile.FileD, rank = CellRank.Rank6),

        Cell(file = CellFile.FileH, rank = CellRank.Rank5),
        Cell(file = CellFile.FileG, rank = CellRank.Rank5),
        Cell(file = CellFile.FileF, rank = CellRank.Rank5),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = false,
        cell = Cell(file = CellFile.FileC, rank = CellRank.Rank2),
        companionKingSide = CompanionKingSide.InShortSide
    ) to listOf(
        Cell(file = CellFile.FileA, rank = CellRank.Rank1),
        Cell(file = CellFile.FileB, rank = CellRank.Rank1),
        Cell(file = CellFile.FileC, rank = CellRank.Rank1),
        Cell(file = CellFile.FileD, rank = CellRank.Rank1),
        Cell(file = CellFile.FileE, rank = CellRank.Rank1),

        Cell(file = CellFile.FileA, rank = CellRank.Rank2),
        Cell(file = CellFile.FileB, rank = CellRank.Rank2),
        Cell(file = CellFile.FileC, rank = CellRank.Rank2),
        Cell(file = CellFile.FileD, rank = CellRank.Rank2),
        Cell(file = CellFile.FileE, rank = CellRank.Rank2),

        Cell(file = CellFile.FileA, rank = CellRank.Rank3),
        Cell(file = CellFile.FileB, rank = CellRank.Rank3),
        Cell(file = CellFile.FileC, rank = CellRank.Rank3),
        Cell(file = CellFile.FileD, rank = CellRank.Rank3),
        Cell(file = CellFile.FileE, rank = CellRank.Rank3),

        Cell(file = CellFile.FileA, rank = CellRank.Rank4),
        Cell(file = CellFile.FileB, rank = CellRank.Rank4),
        Cell(file = CellFile.FileC, rank = CellRank.Rank4),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = false,
        cell = Cell(file = CellFile.FileF, rank = CellRank.Rank2),
        companionKingSide = CompanionKingSide.InShortSide
    ) to listOf(
        Cell(file = CellFile.FileH, rank = CellRank.Rank1),
        Cell(file = CellFile.FileG, rank = CellRank.Rank1),
        Cell(file = CellFile.FileF, rank = CellRank.Rank1),
        Cell(file = CellFile.FileE, rank = CellRank.Rank1),
        Cell(file = CellFile.FileD, rank = CellRank.Rank1),

        Cell(file = CellFile.FileH, rank = CellRank.Rank2),
        Cell(file = CellFile.FileG, rank = CellRank.Rank2),
        Cell(file = CellFile.FileF, rank = CellRank.Rank2),
        Cell(file = CellFile.FileE, rank = CellRank.Rank2),
        Cell(file = CellFile.FileD, rank = CellRank.Rank2),

        Cell(file = CellFile.FileH, rank = CellRank.Rank3),
        Cell(file = CellFile.FileG, rank = CellRank.Rank3),
        Cell(file = CellFile.FileF, rank = CellRank.Rank3),
        Cell(file = CellFile.FileE, rank = CellRank.Rank3),
        Cell(file = CellFile.FileD, rank = CellRank.Rank3),

        Cell(file = CellFile.FileH, rank = CellRank.Rank4),
        Cell(file = CellFile.FileG, rank = CellRank.Rank4),
        Cell(file = CellFile.FileF, rank = CellRank.Rank4),
    ),
    EnemyPawnConfiguration(
        isWhiteSide = true,
        cell = Cell(file = CellFile.FileC, rank = CellRank.Rank7),
        companionKingSide = CompanionKingSide.InLongSide
    ) to listOf(
        Cell(file = CellFile.FileA, rank = CellRank.Rank8),
        Cell(file = CellFile.FileB, rank = CellRank.Rank8),
        Cell(file = CellFile.FileC, rank = CellRank.Rank8),
        Cell(file = CellFile.FileD, rank = CellRank.Rank8),
        Cell(file = CellFile.FileE, rank = CellRank.Rank8),
        Cell(file = CellFile.FileF, rank = CellRank.Rank8),
        Cell(file = CellFile.FileG, rank = CellRank.Rank8),

        Cell(file = CellFile.FileA, rank = CellRank.Rank7),
        Cell(file = CellFile.FileB, rank = CellRank.Rank7),
        Cell(file = CellFile.FileC, rank = CellRank.Rank7),
        Cell(file = CellFile.FileD, rank = CellRank.Rank7),
        Cell(file = CellFile.FileE, rank = CellRank.Rank7),
        Cell(file = CellFile.FileF, rank = CellRank.Rank7),
        Cell(file = CellFile.FileG, rank = CellRank.Rank7),

        Cell(file = CellFile.FileA, rank = CellRank.Rank6),
        Cell(file = CellFile.FileB, rank = CellRank.Rank6),
        Cell(file = CellFile.FileC, rank = CellRank.Rank6),
        Cell(file = CellFile.FileD, rank = CellRank.Rank6),
        Cell(file = CellFile.FileE, rank = CellRank.Rank6),
        Cell(file = CellFile.FileF, rank = CellRank.Rank6),
        Cell(file = CellFile.FileG, rank = CellRank.Rank6),

        Cell(file = CellFile.FileA, rank = CellRank.Rank5),
        Cell(file = CellFile.FileB, rank = CellRank.Rank5),
        Cell(file = CellFile.FileC, rank = CellRank.Rank5),
        Cell(file = CellFile.FileD, rank = CellRank.Rank5),
        Cell(file = CellFile.FileE, rank = CellRank.Rank5),
        Cell(file = CellFile.FileF, rank = CellRank.Rank5),
        Cell(file = CellFile.FileG, rank = CellRank.Rank5),

        Cell(file = CellFile.FileA, rank = CellRank.Rank4),
        Cell(file = CellFile.FileB, rank = CellRank.Rank4),
        Cell(file = CellFile.FileC, rank = CellRank.Rank4),
        Cell(file = CellFile.FileD, rank = CellRank.Rank4),
    ),

    EnemyPawnConfiguration(
        isWhiteSide = true,
        cell = Cell(file = CellFile.FileF, rank = CellRank.Rank7),
        companionKingSide = CompanionKingSide.InLongSide
    ) to listOf(
        Cell(file = CellFile.FileH, rank = CellRank.Rank8),
        Cell(file = CellFile.FileG, rank = CellRank.Rank8),
        Cell(file = CellFile.FileF, rank = CellRank.Rank8),
        Cell(file = CellFile.FileE, rank = CellRank.Rank8),
        Cell(file = CellFile.FileD, rank = CellRank.Rank8),
        Cell(file = CellFile.FileC, rank = CellRank.Rank8),
        Cell(file = CellFile.FileB, rank = CellRank.Rank8),

        Cell(file = CellFile.FileH, rank = CellRank.Rank7),
        Cell(file = CellFile.FileG, rank = CellRank.Rank7),
        Cell(file = CellFile.FileF, rank = CellRank.Rank7),
        Cell(file = CellFile.FileE, rank = CellRank.Rank7),
        Cell(file = CellFile.FileD, rank = CellRank.Rank7),
        Cell(file = CellFile.FileC, rank = CellRank.Rank7),
        Cell(file = CellFile.FileB, rank = CellRank.Rank7),

        Cell(file = CellFile.FileH, rank = CellRank.Rank6),
        Cell(file = CellFile.FileG, rank = CellRank.Rank6),
        Cell(file = CellFile.FileF, rank = CellRank.Rank6),
        Cell(file = CellFile.FileE, rank = CellRank.Rank6),
        Cell(file = CellFile.FileD, rank = CellRank.Rank6),
        Cell(file = CellFile.FileC, rank = CellRank.Rank6),
        Cell(file = CellFile.FileB, rank = CellRank.Rank6),

        Cell(file = CellFile.FileH, rank = CellRank.Rank5),
        Cell(file = CellFile.FileG, rank = CellRank.Rank5),
        Cell(file = CellFile.FileF, rank = CellRank.Rank5),
        Cell(file = CellFile.FileE, rank = CellRank.Rank5),
        Cell(file = CellFile.FileD, rank = CellRank.Rank5),
        Cell(file = CellFile.FileC, rank = CellRank.Rank5),
        Cell(file = CellFile.FileB, rank = CellRank.Rank5),

        Cell(file = CellFile.FileH, rank = CellRank.Rank4),
        Cell(file = CellFile.FileG, rank = CellRank.Rank4),
        Cell(file = CellFile.FileF, rank = CellRank.Rank4),
        Cell(file = CellFile.FileE, rank = CellRank.Rank4),
    ),

    EnemyPawnConfiguration(
        isWhiteSide = false,
        cell = Cell(file = CellFile.FileC, rank = CellRank.Rank2),
        companionKingSide = CompanionKingSide.InLongSide
    ) to listOf(
        Cell(file = CellFile.FileA, rank = CellRank.Rank1),
        Cell(file = CellFile.FileB, rank = CellRank.Rank1),
        Cell(file = CellFile.FileC, rank = CellRank.Rank1),
        Cell(file = CellFile.FileD, rank = CellRank.Rank1),
        Cell(file = CellFile.FileE, rank = CellRank.Rank1),
        Cell(file = CellFile.FileF, rank = CellRank.Rank1),
        Cell(file = CellFile.FileG, rank = CellRank.Rank1),

        Cell(file = CellFile.FileA, rank = CellRank.Rank2),
        Cell(file = CellFile.FileB, rank = CellRank.Rank2),
        Cell(file = CellFile.FileC, rank = CellRank.Rank2),
        Cell(file = CellFile.FileD, rank = CellRank.Rank2),
        Cell(file = CellFile.FileE, rank = CellRank.Rank2),
        Cell(file = CellFile.FileF, rank = CellRank.Rank2),
        Cell(file = CellFile.FileG, rank = CellRank.Rank2),

        Cell(file = CellFile.FileA, rank = CellRank.Rank3),
        Cell(file = CellFile.FileB, rank = CellRank.Rank3),
        Cell(file = CellFile.FileC, rank = CellRank.Rank3),
        Cell(file = CellFile.FileD, rank = CellRank.Rank3),
        Cell(file = CellFile.FileE, rank = CellRank.Rank3),
        Cell(file = CellFile.FileF, rank = CellRank.Rank3),
        Cell(file = CellFile.FileG, rank = CellRank.Rank3),

        Cell(file = CellFile.FileA, rank = CellRank.Rank4),
        Cell(file = CellFile.FileB, rank = CellRank.Rank4),
        Cell(file = CellFile.FileC, rank = CellRank.Rank4),
        Cell(file = CellFile.FileD, rank = CellRank.Rank4),
        Cell(file = CellFile.FileE, rank = CellRank.Rank4),
        Cell(file = CellFile.FileF, rank = CellRank.Rank4),
        Cell(file = CellFile.FileG, rank = CellRank.Rank4),

        Cell(file = CellFile.FileA, rank = CellRank.Rank5),
        Cell(file = CellFile.FileB, rank = CellRank.Rank5),
        Cell(file = CellFile.FileC, rank = CellRank.Rank5),
        Cell(file = CellFile.FileD, rank = CellRank.Rank5),
    ),

    EnemyPawnConfiguration(
        isWhiteSide = false,
        cell = Cell(file = CellFile.FileF, rank = CellRank.Rank2),
        companionKingSide = CompanionKingSide.InLongSide
    ) to listOf(
        Cell(file = CellFile.FileH, rank = CellRank.Rank1),
        Cell(file = CellFile.FileG, rank = CellRank.Rank1),
        Cell(file = CellFile.FileF, rank = CellRank.Rank1),
        Cell(file = CellFile.FileE, rank = CellRank.Rank1),
        Cell(file = CellFile.FileD, rank = CellRank.Rank1),
        Cell(file = CellFile.FileC, rank = CellRank.Rank1),
        Cell(file = CellFile.FileB, rank = CellRank.Rank1),

        Cell(file = CellFile.FileH, rank = CellRank.Rank2),
        Cell(file = CellFile.FileG, rank = CellRank.Rank2),
        Cell(file = CellFile.FileF, rank = CellRank.Rank2),
        Cell(file = CellFile.FileE, rank = CellRank.Rank2),
        Cell(file = CellFile.FileD, rank = CellRank.Rank2),
        Cell(file = CellFile.FileC, rank = CellRank.Rank2),
        Cell(file = CellFile.FileB, rank = CellRank.Rank2),

        Cell(file = CellFile.FileH, rank = CellRank.Rank3),
        Cell(file = CellFile.FileG, rank = CellRank.Rank3),
        Cell(file = CellFile.FileF, rank = CellRank.Rank3),
        Cell(file = CellFile.FileE, rank = CellRank.Rank3),
        Cell(file = CellFile.FileD, rank = CellRank.Rank3),
        Cell(file = CellFile.FileC, rank = CellRank.Rank3),
        Cell(file = CellFile.FileB, rank = CellRank.Rank3),

        Cell(file = CellFile.FileH, rank = CellRank.Rank4),
        Cell(file = CellFile.FileG, rank = CellRank.Rank4),
        Cell(file = CellFile.FileF, rank = CellRank.Rank4),
        Cell(file = CellFile.FileE, rank = CellRank.Rank4),
        Cell(file = CellFile.FileD, rank = CellRank.Rank4),
        Cell(file = CellFile.FileC, rank = CellRank.Rank4),
        Cell(file = CellFile.FileB, rank = CellRank.Rank4),

        Cell(file = CellFile.FileH, rank = CellRank.Rank5),
        Cell(file = CellFile.FileG, rank = CellRank.Rank5),
        Cell(file = CellFile.FileF, rank = CellRank.Rank5),
        Cell(file = CellFile.FileE, rank = CellRank.Rank5),
    ),
)


class Exercise(val pieces: List<List<Char>>, val expectedCells: List<Cell>, val isWhiteTurn: Boolean)

fun generateExercise(): Exercise {
    val random = Random.Default
    val pieces = MutableList(8) { MutableList(8) { emptyCell } }

    fun placePieceRandomly(pieceType: Char) {
        var isDone = false
        do {
            val fileOrdinal = random.nextInt(8)
            val rankOrdinal = random.nextInt(8)
            val isOccupied = pieces[rankOrdinal][fileOrdinal] != emptyCell
            if (!isOccupied) {
                pieces[rankOrdinal][fileOrdinal] = pieceType
                isDone = true
            }
        } while (!isDone)
    }

    val weHaveWhite = random.nextBoolean()

    // placing enemy pawn
    val enemyPawnRank = if (weHaveWhite) CellRank.Rank2 else CellRank.Rank7

    val enemyPawnOnRookColumn = random.nextBoolean()
    val enemyPawnCell = if (enemyPawnOnRookColumn) {
        val enemyPawnOnFileA = random.nextBoolean()
        if (enemyPawnOnFileA) Cell(file = CellFile.FileA, rank = enemyPawnRank) else Cell(
            file = CellFile.FileH,
            rank = enemyPawnRank
        )

    } else {
        val enemyPawnOnFileC = random.nextBoolean()
        if (enemyPawnOnFileC) Cell(file = CellFile.FileC, rank = enemyPawnRank) else Cell(
            file = CellFile.FileF,
            rank = enemyPawnRank
        )
    }

    pieces[enemyPawnCell.rank.ordinal][enemyPawnCell.file.ordinal] = if (weHaveWhite) 'p' else 'P'

    // placing enemy king

    val enemyKingRank = if (enemyPawnCell.rank == CellRank.Rank2) {
        val kingOnFirstRank = random.nextBoolean()
        if (kingOnFirstRank) CellRank.Rank1 else CellRank.Rank2
    } else {
        val kingOnEightRank = random.nextBoolean()
        if (kingOnEightRank) CellRank.Rank8 else CellRank.Rank7
    }

    val enemyKingFile = when (enemyPawnCell.file) {
        CellFile.FileA -> {
            CellFile.FileB
        }

        CellFile.FileH -> {
            CellFile.FileG
        }

        else -> {
            val isLeftOfThePawn = random.nextBoolean()
            val enemyKingFileOrdinal =
                if (isLeftOfThePawn) enemyPawnCell.file.ordinal - 1 else enemyPawnCell.file.ordinal + 1
            CellFile.values()[enemyKingFileOrdinal]
        }
    }

    pieces[enemyKingRank.ordinal][enemyKingFile.ordinal] = if (weHaveWhite) 'k' else 'K'

    // placing our king
    placePieceRandomly(if (weHaveWhite) 'K' else 'k')

    // placing our queen
    placePieceRandomly(if (weHaveWhite) 'Q' else 'q')

    // getting the expected cells
    val companionKingSide = if (enemyPawnCell.file == CellFile.FileA || enemyPawnCell.file == CellFile.FileH) {
        CompanionKingSide.NoImportant
    } else if (enemyPawnCell.file == CellFile.FileC) {
        if (enemyKingFile < CellFile.FileC) CompanionKingSide.InShortSide else CompanionKingSide.InLongSide
    }
    // FileF
    else {
        if (enemyKingFile < CellFile.FileF) CompanionKingSide.InLongSide else CompanionKingSide.InShortSide
    }
    val theExpectedCells = expectedCells[EnemyPawnConfiguration(
        isWhiteSide = !weHaveWhite,
        cell = enemyPawnCell,
        companionKingSide = companionKingSide
    )]!!

    // we can return the exercise
    return Exercise(pieces = pieces, expectedCells = theExpectedCells, isWhiteTurn = weHaveWhite)
}