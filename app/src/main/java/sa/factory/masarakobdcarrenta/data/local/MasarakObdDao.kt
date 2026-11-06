package sa.factory.masarakobdcarrenta.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MasarakObdDao {
    @Query("SELECT * FROM car_rental_items_cache ORDER BY id ASC")
    fun observeAllItems(): Flow<List<MasarakObdEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<MasarakObdEntity>)

    @Query("DELETE FROM car_rental_items_cache")
    suspend fun clearAll()
}
