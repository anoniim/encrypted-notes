package net.solvetheriddle.vault.domain.usecase

import net.solvetheriddle.vault.domain.model.Info
import net.solvetheriddle.vault.domain.repository.InfoRepository
import javax.inject.Inject

class AddInfoUseCase @Inject constructor(
    private val infoStore: InfoRepository
) {

    suspend operator fun invoke(info: Info) {
        infoStore.addInfo(info)
    }
}