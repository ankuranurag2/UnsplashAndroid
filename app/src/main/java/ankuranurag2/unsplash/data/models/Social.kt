package ankuranurag2.unsplash.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Social(
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("portfolio_url")
    val portfolioUrl: String,
    @SerializedName("twitter_username")
    val twitterUsername: String
) : Parcelable