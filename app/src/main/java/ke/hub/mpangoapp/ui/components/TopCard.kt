package ke.hub.mpangoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import ke.hub.mpangoapp.ui.theme.MpangoAppTheme

@Composable
fun TopCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = "Hi there",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )
            Text(
                text = "Kes 56000.00",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun TopCardPreview() {
    MpangoAppTheme {
        TopCard()
    }
}
