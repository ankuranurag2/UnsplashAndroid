package ankuranurag2.unsplash.domain.usecases

import ankuranurag2.unsplash.domain.repository.AccessKeyRepository
import javax.inject.Inject

class GetKeyUseCase @Inject constructor(
    private val repository: AccessKeyRepository
) {
    operator fun invoke() = repository.getAccessKey()
}