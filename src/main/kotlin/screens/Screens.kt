package screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import logic.Exercise
import logic.Solution

class Home : Screen {
    @Composable
    override fun Content() {
        HomePage()
    }
}

class Game : Screen {
    @Composable
    override fun Content() {
        GamePage()
    }
}

data class Solution(val solutionData: Solution, val exercise: Exercise) : Screen {
    @Composable
    override fun Content() {
        SolutionPage(solution = solutionData, exercise = exercise)
    }
}