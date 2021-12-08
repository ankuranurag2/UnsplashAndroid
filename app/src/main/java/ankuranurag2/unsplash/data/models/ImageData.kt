package ankuranurag2.unsplash.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ImageData(
    @PrimaryKey
    @SerializedName("url")
    val url: String
) : Parcelable{
    @IgnoredOnParcel
    @ColumnInfo
    var pageNum:Int=1
}