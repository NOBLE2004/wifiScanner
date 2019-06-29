package com.android.wifiscanner.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ListData::class), version = 1, exportSchema = false)
abstract class WifiDatabase : RoomDatabase() {
    abstract fun wifiDatabasedao(): WifiDatabasedao

}