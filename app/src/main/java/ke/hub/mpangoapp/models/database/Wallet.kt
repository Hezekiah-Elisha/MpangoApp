package ke.hub.mpangoapp.models.database

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "wallets")
data class Wallet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val balance: Double,
    val currency: String,
)
