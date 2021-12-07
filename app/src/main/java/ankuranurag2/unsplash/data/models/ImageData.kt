package ankuranurag2.unsplash.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageData(
    @SerializedName("id")
    val id: String,
    @SerializedName("urls")
    val urls: Urls
) : Parcelable