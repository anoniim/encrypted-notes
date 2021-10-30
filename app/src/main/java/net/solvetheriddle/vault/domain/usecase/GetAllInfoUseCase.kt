package net.solvetheriddle.vault.domain.usecase

import net.solvetheriddle.vault.domain.model.Info
import net.solvetheriddle.vault.domain.repository.InfoRepository
import javax.inject.Inject

class GetAllInfoUseCase @Inject constructor(
    private val infoStore: InfoRepository
) {

    suspend operator fun invoke(): List<Info> {
        return infoStore.getAllInfo()
    }
}