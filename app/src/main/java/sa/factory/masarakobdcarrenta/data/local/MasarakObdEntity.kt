package sa.factory.masarakobdcarrenta.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import sa.factory.masarakobdcarrenta.model.MasarakObdItem

@Entity(tableName = "car_rental_items_cache")
data class MasarakObdEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val priceSar: Double,
    val badge: String,
    val category: String,
    val status: String
) {
    fun toDomain(): MasarakObdItem = MasarakObdItem(
        id = id,
        title = title,
        description = description,
        priceSar = priceSar,
        badge = badge,
        category = category,
        status = status
    )
}
