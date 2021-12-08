package ankuranurag2.unsplash.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ankuranurag2.unsplash.data.models.ImageData

@Database(entities = [ImageData::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {
    abstract fun getDao(): ImageDao
}