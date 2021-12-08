package ankuranurag2.unsplash.presentation.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ankuranurag2.unsplash.R
import ankuranurag2.unsplash.data.models.ImageData
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PopularRootLayout() {
    val viewModel: MainViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (uiState.imageList.isNotEmpty()) {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    state = rememberLazyListState(),
                    contentPadding = PaddingValues(8.dp, 8.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    items(uiState.imageList) {
                        ImageItem(imageData = it)
                    }
                }
            }
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.wrapContentSize())
            }

            uiState.errorMessage?.let {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(message = it)
                }
            }
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
        onClick = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageData.urls.full,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.ic_loading)
                    error(R.drawable.ic_error)
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .aspectRatio(1f)
                .background(Color.Yellow)
        )
    }
}