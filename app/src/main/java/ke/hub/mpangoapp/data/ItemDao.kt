package ke.hub.mpangoapp.data

import androidx.room3.Dao
import androidx.room3.Query
import ke.hub.mpangoapp.models.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<Item>
}
