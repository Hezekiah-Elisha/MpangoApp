package ke.hub.mpangoapp.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import ke.hub.mpangoapp.ui.screens.AnalyticsScreen
import ke.hub.mpangoapp.ui.screens.HomeScreen
import ke.hub.mpangoapp.ui.screens.TransferScreen

@Composable
fun ApplicationNavigation(modifier: Modifier = Modifier) {
    val topLevelBackStack = remember { TopLevelBackStack<NavKey>(Route.Home) }
    val currentKey = topLevelBackStack.topLevelKey

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            if (currentKey is Route) {
//                ChessBottomBar(
//                    currentRoute = currentKey,
//                    onTabSelected = { route ->
//                        topLevelBackStack.switchTopLevel(route)
//                    },
//                )
                BottomNav(
                    currentRoute = currentKey,
                    topLevelBackStack = topLevelBackStack,
                )
            }
        },
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = topLevelBackStack.backStack,
            onBack = { topLevelBackStack.removeLastOrNull() },
            entryProvider =
                entryProvider {
                    entry(Route.Home) {
                        HomeScreen(
                            onNavigateToTransfer = { topLevelBackStack.backStack.add(Route.Transfer) },
                            onNavigateToAnalytics = { topLevelBackStack.backStack.add(Route.Analytics) },
                        )
                    }
                    entry(Route.Transfer) {
                        TransferScreen(onBack = { topLevelBackStack.removeLastOrNull() })
                    }
                    entry(Route.Analytics) {
                        AnalyticsScreen(onBack = { topLevelBackStack.removeLastOrNull() })
                    }
                },
        )
    }
}
