package ke.hub.mpangoapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation3.runtime.NavKey
import ke.hub.mpangoapp.ui.theme.MpangoAppTheme

@Composable
fun BottomNav(
    currentRoute: Route = Route.Home,
    topLevelBackStack: TopLevelBackStack<NavKey> = remember { TopLevelBackStack(Route.Home) },
) {
    val bottomNavItems = listOf(Route.Home, Route.Analytics, Route.Transfer)
    // Only display bottom bar on main screens
    if (currentRoute !in listOf(Route.Home, Route.Analytics, Route.Transfer)) {
        return
    }

    NavigationBar {
        bottomNavItems.forEach { route ->
            NavigationBarItem(
                selected = topLevelBackStack.topLevelKey == route,
                onClick = {
                    topLevelBackStack.switchTopLevel(
                        key = route,
                    )
                },
                icon = {
                    val icon =
                        if (topLevelBackStack.topLevelKey == route) {
                            route.selectedIcon
                        } else {
                            route.unselectedIcon
                        }
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = route.label,
                    )
                },
                label = {
                    Text(
                        route.label,
                    )
                },
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun BottomNavPreview() {
    MpangoAppTheme {
        BottomNav()
    }
}
