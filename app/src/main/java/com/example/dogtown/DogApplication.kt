package com.example.dogtown

import android.app.Application
import com.example.dogtown.database.AppDatabase
import kotlinx.coroutines.InternalCoroutinesApi


class DogApplication : Application() {

    @OptIn(InternalCoroutinesApi::class)
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}