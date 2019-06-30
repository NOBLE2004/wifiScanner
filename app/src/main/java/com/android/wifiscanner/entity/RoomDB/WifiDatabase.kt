package com.android.wifiscanner.entity.database


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(WifiData::class), version = 1, exportSchema = false)
abstract class WifiDatabase : RoomDatabase() {
    abstract fun wifiDatabasedao(): WifiDatabasedao

}