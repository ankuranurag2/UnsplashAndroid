package ankuranurag2.unsplash.presentation.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            state = rememberLazyListState(),
            contentPadding = PaddingValues(8.dp, 8.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Green)
        ) {
            items(uiState.value.imageList) {
                ImageItem(imageData = it)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ImageItem(
    imageData: ImageData
) {
//    Card(
//        elevation = 4.dp,
//        onClick = {},
//        modifier = Modifier.fillMaxSize().background(Color.Red)
//    ) {
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
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        )
//    }
}