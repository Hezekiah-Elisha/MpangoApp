package ke.hub.mpangoapp.data

import androidx.room3.Database
import androidx.room3.RoomDatabase
import ke.hub.mpangoapp.models.database.Item
import ke.hub.mpangoapp.models.database.Wallet

@Database(entities = [Item::class, Wallet::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    abstract fun walletDao(): WalletDao
}
