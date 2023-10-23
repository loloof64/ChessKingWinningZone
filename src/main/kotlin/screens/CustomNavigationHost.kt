package screens

import androidx.compose.runtime.Composable

@Composable
fun CustomNavigationHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screens.Home.name) {
            HomePage(navController)
        }

        composable(Screens.Game.name) {
            GamePage(navController)
        }

    }.build()
}