package ke.hub.mpangoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ke.hub.mpangoapp.ui.components.*
import ke.hub.mpangoapp.ui.theme.MpangoAppTheme

@Composable
fun AnalyticsScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(Color.Black),
    ) {
        // White background at the bottom
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .align(Alignment.BottomCenter)
                    .background(Color.White),
        )

        // Wavy separator
        WavyBackground(
            color = Color.Black,
            modifier =
                Modifier
                    .align(Alignment.Center)
                    .offset(y = (-80).dp),
            height = 350f,
        )

        // Another wavy layer if needed, but the design shows a white bottom area starting with a wave.
        // Actually, let's use a white wavy background on top of black
        WavyBackground(
            color = Color.White,
            modifier =
                Modifier
                    .align(Alignment.Center)
                    .offset(y = 20.dp),
            height = 400f,
        )

        Column(modifier = Modifier.fillMaxSize()) {
            // App Bar
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                }
                Text(
                    text = "Analytics",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Default.CalendarMonth, contentDescription = null, tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Chart
            SpendingChart(
                data = listOf(0.4f, 0.6f, 0.5f, 0.7f, 0.9f, 0.4f, 0.5f),
                days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"),
            )

            Spacer(modifier = Modifier.height(64.dp))

            // Savings Goals Section
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 24.dp),
            ) {
                Text(
                    text = "Savings Goals",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp),
                ) {
                    items(
                        listOf(
                            "Emergency" to 85,
                            "Travel" to 70,
                            "Home renovation" to 65,
                            "Healthcare" to 37,
                        ),
                    ) { (title, percentage) ->
                        SavingsGoalItem(title = title, percentage = percentage)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnalyticsScreenPreview() {
    MpangoAppTheme {
        AnalyticsScreen(onBack = {})
    }
}
