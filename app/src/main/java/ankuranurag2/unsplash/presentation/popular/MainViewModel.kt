package ankuranurag2.unsplash.presentation.popular

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ankuranurag2.unsplash.data.models.ImageData
import ankuranurag2.unsplash.domain.usecases.GetImagesUseCase
import ankuranurag2.unsplash.domain.usecases.GetKeyUseCase
import ankuranurag2.unsplash.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getKeyUseCase: GetKeyUseCase,
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    private var pageNum = 1

    private val _uiState = mutableStateOf(UiState())
    val uiState: State<UiState> get() = _uiState

    fun fetchPopularImages() {
        viewModelScope.launch {
            getImagesUseCase.invoke(GetImagesUseCase.Param(getKeyUseCase(), pageNum++))
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _uiState.value = uiState.value.copy(
                                imageList = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _uiState.value = uiState.value.copy(
                                imageList = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _uiState.value = uiState.value.copy(
                                imageList = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }
        }
    }
}

data class UiState(
    val isLoading: Boolean = true,
    val imageList: List<ImageData> = emptyList()
)