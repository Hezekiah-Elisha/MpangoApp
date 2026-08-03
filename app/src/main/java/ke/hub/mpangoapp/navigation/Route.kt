package ke.hub.mpangoapp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

interface BottomNavRoute {
    val selectedIcon: Int
    val unselectedIcon: Int
    val label: String
}

sealed interface Route : NavKey {
    @Serializable
    data object Home : Route, BottomNavRoute, NavKey {
        override val selectedIcon: Int
            get() = TODO("Not yet implemented")
        override val unselectedIcon: Int
            get() = TODO("Not yet implemented")
        override val label = "Home"
    }

    @Serializable
    data object Transfer : Route, BottomNavRoute, NavKey {
        override val selectedIcon: Int
            get() = TODO("Not yet implemented")
        override val unselectedIcon: Int
            get() = TODO("Not yet implemented")
        override val label = "Transfer"
    }

    @Serializable
    data object Analytics : Route, BottomNavRoute, NavKey {
        override val selectedIcon: Int
            get() = TODO("Not yet implemented")
        override val unselectedIcon: Int
            get() = TODO("Not yet implemented")
        override val label = "Analytics"
    }
}
