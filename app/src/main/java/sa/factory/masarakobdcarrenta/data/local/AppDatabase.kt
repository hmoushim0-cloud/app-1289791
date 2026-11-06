package sa.factory.masarakobdcarrenta.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MasarakObdEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun car_rentalDao(): MasarakObdDao
}
