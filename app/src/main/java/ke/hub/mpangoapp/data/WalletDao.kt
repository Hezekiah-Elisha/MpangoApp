package ke.hub.mpangoapp.data

import androidx.room3.Dao
import androidx.room3.Query
import ke.hub.mpangoapp.models.database.Wallet

@Dao
interface WalletDao {
    @Query("SELECT * FROM wallets")
    suspend fun getAllWallets(): List<Wallet>
}
