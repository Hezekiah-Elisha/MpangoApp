package ke.hub.mpangoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ke.hub.mpangoapp.ui.components.*
import ke.hub.mpangoapp.ui.theme.MpangoAppTheme

@Composable
fun TransferScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var amount by remember { mutableStateOf("160") }

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(Color.White),
    ) {
        // Black wavy background at the top
        WavyBackground(
            color = Color.Black,
            modifier =
                Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 200.dp),
            height = 400f,
        )

        WavyBackground(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.TopCenter),
            height = 300f,
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
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = Color.Black)
                }
                Text(
                    text = "Transfer money",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Default.MoreVert, contentDescription = null, tint = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Amount Display
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "KES ",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )
                Text(
                    text = amount,
                    style =
                        MaterialTheme.typography.displayLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 64.sp,
                        ),
                    color = Color.Black,
                )
                Text(
                    text = ".00",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black.copy(alpha = 0.4f),
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Contacts
            LazyRow(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(listOf("Aron", "Fiona", "Diana", "Ethan", "Bella")) { name ->
                    ContactItem(name = name, isSelected = name == "Fiona")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Keypad
            NumericKeypad(
                onNumberClick = { num -> amount += num },
                onDeleteClick = { if (amount.isNotEmpty()) amount = amount.dropLast(1) },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
            )

            // Send Button
            Button(
                onClick = {},
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(64.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(
                    text = "Send money",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TransferScreenPreview() {
    MpangoAppTheme {
        TransferScreen(onBack = {})
    }
}
