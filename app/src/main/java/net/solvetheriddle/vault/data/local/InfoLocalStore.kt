package net.solvetheriddle.vault.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import net.solvetheriddle.vault.domain.model.Info
import net.solvetheriddle.vault.domain.repository.InfoRepository
import javax.inject.Inject

private const val INFO_SHARED_PREFS = "infos"
private const val KEY_PREFIX = "info-"

class InfoLocalStore @Inject constructor(
    context: Context,
    private val gson: Gson,
) : InfoRepository {

    private val sharedPrefs: SharedPreferences = context.getSharedPreferences(INFO_SHARED_PREFS, Context.MODE_PRIVATE)

    override suspend fun addInfo(info: Info) {
        val value = gson.toJson(info)
        sharedPrefs.edit()
            .putString(KEY_PREFIX + info.name, value)
            .apply()
    }

    override suspend fun getInfo(name: String): Info? {
        val serializedInfo = sharedPrefs.getString(KEY_PREFIX + name, null)
        return try {
            gson.fromJson(serializedInfo, Info::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getAllInfo(): List<Info> {
        return sharedPrefs.all?.map {
            gson.fromJson(it.value as String, Info::class.java)
        } ?: emptyList()
    }
}