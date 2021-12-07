package ankuranurag2.unsplash.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Sponsorship(
    @SerializedName("impression_urls")
    val impressionUrls: List<String>,
    @SerializedName("sponsor")
    val sponsor: Sponsor,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("tagline_url")
    val taglineUrl: String
) : Parcelable