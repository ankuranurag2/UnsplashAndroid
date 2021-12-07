package ankuranurag2.unsplash.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopicSubmissions(
    @SerializedName("film")
    val film: Film
) : Parcelable