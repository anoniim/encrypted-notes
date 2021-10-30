package net.solvetheriddle.vault.domain.repository

import net.solvetheriddle.vault.domain.model.Info

interface InfoRepository {

    suspend fun addInfo(info: Info)

    suspend fun getInfo(name: String): Info?

    suspend fun getAllInfo(): List<Info>
}
