package components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.missedCellColor
import common.rightCellColor
import common.wrongCellColor
import i18n.LocalStrings

val textsSize = 30.sp
val colorSquaresSize = 30.dp
val legendHorizontalPadding = 10.dp

@Composable
fun SolutionLegend(modifier: Modifier = Modifier) {
    val strings = LocalStrings.current
    Column(
        modifier = modifier.padding(horizontal = legendHorizontalPadding),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {
        SolutionLegendHeader()
        SolutionLegendItem(itemColor = rightCellColor, caption = strings.goodSquare)
        SolutionLegendItem(itemColor = wrongCellColor, caption = strings.wrongSquare)
        SolutionLegendItem(itemColor = missedCellColor, caption = strings.missedSquare)
    }
}

@Composable
fun SolutionLegendHeader() {
    val strings = LocalStrings.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = strings.legend, fontSize = textsSize)
    }
}

@Composable
fun SolutionLegendItem(itemColor: Color, caption: String) {
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        Surface(modifier = Modifier.size(colorSquaresSize, colorSquaresSize), color = itemColor) {}
        Text(text = caption, fontSize = textsSize)
    }
}