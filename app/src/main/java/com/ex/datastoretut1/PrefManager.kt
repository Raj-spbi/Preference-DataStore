//package com.ex.datastoretut1
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.intPreferencesKey
//import androidx.datastore.preferences.core.stringPreferencesKey
//import androidx.datastore.preferences.preferencesDataStore
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//class PrefManager(private val context: Context) {
//    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("AppPref")
//
//    companion object {
//        val id = intPreferencesKey("id")
//        val name = stringPreferencesKey("name")
//        val email = stringPreferencesKey("email")
//        val mobile = stringPreferencesKey("mobile")
//        lateinit var modelUser: ModelUser
//    }
//
//    suspend fun storeUser(modelUser: ModelUser) {
//        context.dataStore.edit {
//            it[id] = modelUser.id
//            it[name] = modelUser.name
//            it[email] = modelUser.email
//            it[mobile] = modelUser.mobile
//        }
//    }
//
//    fun isUserLoggedIn(): Flow<Any> = context.dataStore.data.map {
//        it[id] ?: false
//    }
//
//    suspend fun getUser()= context.dataStore.data.map {
////        modelUser = ModelUser(it[id]!!, it[name]!!, it[email]!!, it[mobile]!!)
//
//    }
//
//    fun getUserDetails(): Flow<Unit> = context.dataStore.data.map {
////        modelUser = ModelUser(it[id]!!, it[name]!!, it[email]!!, it[mobile]!!)
//
//    }
//
//
//}