package ankuranurag2.unsplash.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ImageData(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String
) : Parcelable