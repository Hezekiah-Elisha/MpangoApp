package ke.hub.mpangoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import ke.hub.mpangoapp.R
import ke.hub.mpangoapp.models.Bill
import ke.hub.mpangoapp.ui.components.BillsItem
import ke.hub.mpangoapp.ui.theme.MpangoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToTransfer: () -> Unit,
    onNavigateToAnalytics: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val bills =
        listOf(
            Bill("Netflix", "Subscription", 1200.00),
            Bill("Amazon", "Shopping", 9800.00),
            Bill("Starbucks", "Food & Drinks", 350.00),
            Bill("Uber", "Transport", 1600.00),
        )
//    Box(
//        modifier =
//            modifier
//                .fillMaxSize()
//                .background(Color.Black),
//    ) {
//        // White background at the bottom
//        Box(
//            modifier =
//                Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.6f)
//                    .align(Alignment.BottomCenter)
//                    .background(Color.White),
//        )
//
//        // Wavy separator
//        WavyBackground(
//            color = MaterialTheme.colorScheme.primary,
//            modifier =
//                Modifier
//                    .align(Alignment.Center)
//                    .offset(y = (-50).dp),
//            height = 400f,
//        )
//
//        Column(modifier = Modifier.fillMaxSize()) {
//            // Header
//            Row(
//                modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(24.dp)
//                        .padding(top = 32.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically,
//            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Box(
//                        modifier =
//                            Modifier
//                                .size(48.dp)
//                                .clip(CircleShape)
//                                .background(Color.Gray),
//                    )
//                    Spacer(modifier = Modifier.width(12.dp))
//                    Column {
//                        Text(
//                            text = "Hi there",
//                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
//                            color = Color.White,
//                        )
//                        Text(
//                            text = "Your wallet",
//                            style = MaterialTheme.typography.bodySmall,
//                            color = Color.White.copy(alpha = 0.6f),
//                        )
//                    }
//                }
//                Icon(
//                    imageVector = Icons.Default.Notifications,
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier.size(28.dp),
//                )
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Balance Card
//            BalanceCard(
//                balance = "3,200.00",
//                cardNumber = "4466 98** **** 8841",
//                expiryDate = "08/2028",
//            )
//
//            Spacer(modifier = Modifier.height(32.dp))
//
//            // Action Buttons
//            Row(
//                modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 24.dp),
//                horizontalArrangement = Arrangement.spacedBy(12.dp),
//            ) {
//                ActionButton(icon = Icons.Default.VerticalAlignBottom)
//                ActionButton(icon = Icons.Default.CallMade, onClick = onNavigateToTransfer)
//                ActionButton(icon = Icons.Default.Add)
//                ActionButton(
//                    icon = Icons.Default.Apps,
//                    containerColor = Color.Black,
//                    contentColor = Color.White,
//                    onClick = onNavigateToAnalytics,
//                )
//            }
//
//            Spacer(modifier = Modifier.height(48.dp))
//
//            // Transactions
//            Column(
//                modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 24.dp)
//                        .weight(1f),
//            ) {
//                Text(
//                    text = "Transactions",
//                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
//                    color = Color.Black,
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                LazyColumn(
//                    verticalArrangement = Arrangement.spacedBy(8.dp),
//                    contentPadding = PaddingValues(bottom = 24.dp),
//                ) {
//                    items(
//                        listOf(
//                            Triple("Netflix", "Subscription", "1,200.00"),
//                            Triple("Amazon", "Shopping", "9,800.00"),
//                            Triple("Starbucks", "Food & Drinks", "350.00"),
//                            Triple("Uber", "Transport", "1,600.00"),
//                        ),
//                    ) { (name, category, amount) ->
//                        TransactionItem(
//                            name = name,
//                            category = category,
//                            amount = amount,
//                            iconLetter = name.take(1),
//                        )
//                    }
//                }
//            }
//        }
//    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Mpango App") },
                actions = {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.notifications_24dp_e3e3e3_fill1_wght400_grad0_opsz24),
                            contentDescription = null,
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Hello there Planner",
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(
                    text = "Lets get you started kwa mpangilio",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Your Wallets")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Card(
                        colors =
                            CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            ),
                        modifier =
                            Modifier
                                .size(width = 140.dp, height = 100.dp),
                    ) {
                        Column {
                            Text("Wallet 1")
                            Text("KES 1,200.00")
                        }
                    }
                    Card(
                        colors =
                            CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            ),
                        modifier =
                            Modifier
                                .size(width = 140.dp, height = 100.dp),
                    ) {
                        Column {
                            Text("Wallet 2")
                            Text("KES 1,200.00")
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Your Upcoming bills",
                    style = MaterialTheme.typography.titleLarge,
                )
                LazyColumn {
                    items(bills) { bill ->
                        BillsItem(
                            name = bill.organization,
                            category = bill.type,
                            amount = bill.amount.toString(),
                            iconLetter = bill.organization.take(1),
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    MpangoAppTheme {
        HomeScreen(onNavigateToTransfer = {}, onNavigateToAnalytics = {})
    }
}
