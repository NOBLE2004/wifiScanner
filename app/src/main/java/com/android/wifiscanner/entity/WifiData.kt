package com.android.wifiscanner.entity.database

import androidx.room.Entity

@Entity(primaryKeys = arrayOf("wifiname"),tableName = "wifi_table")
data class WifiData (
    var wifiname:String ,
    var wifiStrength:Int)