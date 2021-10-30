package net.solvetheriddle.vault.domain.model

data class Info(
    val name: String,
    val value: String,
    val type: InfoType,
//    val category: InfoCategory,
    val dateCreated: Long,
    val dateUpdated: Long,
)