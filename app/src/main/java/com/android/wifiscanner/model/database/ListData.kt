package com.android.wifiscanner.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = arrayOf("wifiname"),tableName = "wifi_log_table")
data class ListData (
    var wifiname:String ,
    var wifiStrength:Int)