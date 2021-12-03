package com.example.dogtown

import android.app.Application
import com.example.dogtown.database.AppDatabase


class DogApplication : Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}