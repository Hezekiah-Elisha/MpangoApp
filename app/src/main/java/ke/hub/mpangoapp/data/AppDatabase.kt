package ke.hub.mpangoapp.data

import androidx.room3.Database
import androidx.room3.RoomDatabase
import ke.hub.mpangoapp.models.Item

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
