package ke.hub.mpangoapp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Route : NavKey {
    @Serializable
    data object Home : Route, NavKey

    @Serializable
    data object Transfer : Route, NavKey

    @Serializable
    data object Analytics : Route, NavKey
}
