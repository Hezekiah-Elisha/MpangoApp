package ke.hub.mpangoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.CallMade
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.VerticalAlignBottom
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ke.hub.mpangoapp.ui.components.ActionButton
import ke.hub.mpangoapp.ui.components.BalanceCard
import ke.hub.mpangoapp.ui.components.TransactionItem
import ke.hub.mpangoapp.ui.components.WavyBackground
import ke.hub.mpangoapp.ui.theme.MpangoAppTheme

@Composable
fun HomeScreen(
    onNavigateToTransfer: () -> Unit,
    onNavigateToAnalytics: () -> Unit,
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
                    .fillMaxHeight(0.6f)
                    .align(Alignment.BottomCenter)
                    .background(Color.White),
        )

        // Wavy separator
        WavyBackground(
            color = MaterialTheme.colorScheme.primary,
            modifier =
                Modifier
                    .align(Alignment.Center)
                    .offset(y = (-50).dp),
            height = 400f,
        )

        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier =
                            Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Color.Gray),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Hi there",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White,
                        )
                        Text(
                            text = "Your wallet",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.6f),
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp),
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Balance Card
            BalanceCard(
                balance = "3,200.00",
                cardNumber = "4466 98** **** 8841",
                expiryDate = "08/2028",
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Action Buttons
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                ActionButton(icon = Icons.Default.VerticalAlignBottom)
                ActionButton(icon = Icons.Default.CallMade, onClick = onNavigateToTransfer)
                ActionButton(icon = Icons.Default.Add)
                ActionButton(
                    icon = Icons.Default.Apps,
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    onClick = onNavigateToAnalytics,
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Transactions
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .weight(1f),
            ) {
                Text(
                    text = "Transactions",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(bottom = 24.dp),
                ) {
                    items(
                        listOf(
                            Triple("Netflix", "Subscription", "1,200.00"),
                            Triple("Amazon", "Shopping", "9,800.00"),
                            Triple("Starbucks", "Food & Drinks", "350.00"),
                            Triple("Uber", "Transport", "1,600.00"),
                        ),
                    ) { (name, category, amount) ->
                        TransactionItem(
                            name = name,
                            category = category,
                            amount = amount,
                            iconLetter = name.take(1),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MpangoAppTheme {
        HomeScreen(onNavigateToTransfer = {}, onNavigateToAnalytics = {})
    }
}
