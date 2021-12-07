package ankuranurag2.unsplash.data.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Sponsor(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("for_hire")
    val forHire: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("name")
    val name: String,
    @SerializedName("portfolio_url")
    val portfolioUrl: String,
    @SerializedName("profile_image")
    val profileImage: ProfileImage,
    @SerializedName("social")
    val social: Social,
    @SerializedName("total_collections")
    val totalCollections: Int,
    @SerializedName("total_likes")
    val totalLikes: Int,
    @SerializedName("total_photos")
    val totalPhotos: Int,
    @SerializedName("twitter_username")
    val twitterUsername: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String
) : Parcelable