package ankuranurag2.unsplash.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ankuranurag2.unsplash.data.models.ImageData

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(imageList: List<ImageData>)

    @Query("SELECT * FROM imagedata WHERE pageNum=:page")
    suspend fun fetchImagesForPage(page: Int): List<ImageData>
}