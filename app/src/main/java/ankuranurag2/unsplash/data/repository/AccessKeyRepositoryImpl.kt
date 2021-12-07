package ankuranurag2.unsplash.data.repository

import ankuranurag2.unsplash.domain.repository.AccessKeyRepository

class AccessKeyRepositoryImpl : AccessKeyRepository {
    override fun getAccessKey(): String {
        return "YOUR_API_KEY"
    }
}