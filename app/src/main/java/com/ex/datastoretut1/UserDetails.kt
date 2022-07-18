package com.ex.datastoretut1

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class UserDetails(private val context: Context) {


    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("pref")

    companion object {
        val USERNAME = stringPreferencesKey("USER_NAME")
        val AGE = intPreferencesKey("AGE")
    }


    suspend fun storeUser(name: String, age: Int) {
        context.dataStore.edit {
            it[USERNAME] = name
            it[AGE] = age
        }
    }


    fun getUserName() = context.dataStore.data.map {
        it[USERNAME] ?: ""
    }

    fun getUserAge() = context.dataStore.data.map {
        it[AGE] ?: -1
    }
    /**    How we can use them in Any Activity or Fragment:
     *
     *
     *
     *  var userDetails = UserDetails(context = this)



    lifecycle.coroutineScope.launchWhenCreated {
    userDetails.getUserAge().collect {
    binding.age.text = it.toString()
    }

    }


    lifecycle.coroutineScope.launchWhenCreated {
    userDetails.getUserName().collect {
    binding.name.text = it.toString()
    }

    }

    binding.saveData.setOnClickListener {
    CoroutineScope(IO).launch {
    userDetails.storeUser(
    binding.enterName.text.toString().trim(),
    binding.enterAge.text.toString().trim().toInt()
    )
    }


    }
     */
}