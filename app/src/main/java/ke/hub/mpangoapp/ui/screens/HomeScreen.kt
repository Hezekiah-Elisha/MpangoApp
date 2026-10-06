package ke.hub.mpangoapp.ui.screens

import android.util.Log
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
import androidx.compose.material3.ExtendedFloatingActionButton
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
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    Log.d("HomeButton", "HomeScreen: FloatingActionButton clicked")
                },
            ) {
                Text(text = "Add")
            }
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
                modifier =
                    Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
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
