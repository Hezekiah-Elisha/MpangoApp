package ke.hub.mpangoapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun WavyBackground(
    color: Color,
    modifier: Modifier = Modifier,
    height: Float = 400f,
) {
    Canvas(modifier = modifier.fillMaxWidth().height(height.dp)) {
        val path =
            Path().apply {
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(size.width, size.height * 0.8f)

                cubicTo(
                    size.width * 0.85f,
                    size.height * 0.8f,
                    size.width * 0.75f,
                    size.height * 0.95f,
                    size.width * 0.65f,
                    size.height * 0.95f,
                )
                cubicTo(
                    size.width * 0.55f,
                    size.height * 0.95f,
                    size.width * 0.45f,
                    size.height * 0.8f,
                    size.width * 0.35f,
                    size.height * 0.8f,
                )
                cubicTo(
                    size.width * 0.25f,
                    size.height * 0.8f,
                    size.width * 0.15f,
                    size.height * 0.95f,
                    0f,
                    size.height * 0.95f,
                )
                lineTo(0f, 0f)
                close()
            }
        drawPath(path = path, color = color)
    }
}
