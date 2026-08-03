package ke.hub.mpangoapp.navigation

import androidx.navigation3.runtime.NavKey
import ke.hub.mpangoapp.R
import kotlinx.serialization.Serializable

interface BottomNavRoute {
    val selectedIcon: Int
    val unselectedIcon: Int
    val label: String
}

sealed interface Route : NavKey {
    @Serializable
    data object Home : Route, BottomNavRoute, NavKey {
        override val selectedIcon = R.drawable.home_24dp_e3e3e3_fill1_wght400_grad0_opsz24
        override val unselectedIcon = R.drawable.home_24dp_e3e3e3_fill0_wght400_grad0_opsz24
        override val label = "Home"
    }

    @Serializable
    data object Transfer : Route, BottomNavRoute, NavKey {
        override val selectedIcon = R.drawable.add_card_24dp_e3e3e3_fill1_wght400_grad0_opsz24
        override val unselectedIcon = R.drawable.add_card_24dp_e3e3e3_fill0_wght400_grad0_opsz24
        override val label = "Transfer"
    }

    @Serializable
    data object Analytics : Route, BottomNavRoute, NavKey {
        override val selectedIcon = R.drawable.settings_24dp_e3e3e3_fill1_wght400_grad0_opsz24
        override val unselectedIcon = R.drawable.settings_24dp_e3e3e3_fill0_wght400_grad0_opsz24
        override val label = "Analytics"
    }
}
