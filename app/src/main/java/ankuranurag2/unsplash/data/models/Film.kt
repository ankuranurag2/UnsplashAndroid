package ankuranurag2.unsplash.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Film(
    @SerializedName("approved_on")
    val approvedOn: String,
    @SerializedName("status")
    val status: String
) : Parcelable