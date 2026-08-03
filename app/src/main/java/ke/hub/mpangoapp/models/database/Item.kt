package ke.hub.mpangoapp.models.database

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val amount: Double,
)
