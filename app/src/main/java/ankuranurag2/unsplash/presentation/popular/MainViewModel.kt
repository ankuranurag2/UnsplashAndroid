package ankuranurag2.unsplash.presentation.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ankuranurag2.unsplash.data.models.ImageData
import ankuranurag2.unsplash.domain.usecases.GetImagesUseCase
import ankuranurag2.unsplash.domain.usecases.GetKeyUseCase
import ankuranurag2.unsplash.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getKeyUseCase: GetKeyUseCase,
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    private var pageNum = 1

    private val _uiState = MutableStateFlow<UiState>(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchPopularImages()
    }

    fun fetchPopularImages() {
        viewModelScope.launch {
            getImagesUseCase(GetImagesUseCase.Param(getKeyUseCase(), pageNum++))
                .collect { result ->
                    _uiState.update {
                        when (result) {
                            is Resource.Success ->
                                it.copy(imageList = result.data ?: emptyList(), isLoading = false)
                            is Resource.Error ->
                                it.copy(imageList = result.data ?: emptyList(), isLoading = false)
                            is Resource.Loading ->
                                it.copy(imageList = result.data ?: emptyList(), isLoading = true)
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