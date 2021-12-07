package ankuranurag2.unsplash.presentation.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ankuranurag2.unsplash.R
import ankuranurag2.unsplash.data.models.ImageData
import coil.compose.rememberImagePainter
import coil.size.Scale

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PopularRootLayout() {
    val viewModel: MainViewModel = hiltViewModel()
    val uiState = viewModel.uiState.value

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        state = rememberLazyListState()
    ) {
        items(uiState.imageList) {
            ImageItem(imageData = it)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ImageItem(
    imageData: ImageData
) {
    Card(
        elevation = 4.dp,
        onClick = {}
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageData.urls.full,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.ic_loading)
                    error(R.drawable.ic_error)
                    scale(Scale.FILL)
                }
            ),
            contentDescription = null,
            Modifier.aspectRatio(1f, true)
        )
    }
}