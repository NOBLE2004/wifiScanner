package com.android.wifiscanner.utils


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

import com.android.wifiscanner.R
import com.android.wifiscanner.entity.database.WifiData

@BindingAdapter("setWifiName")
fun TextView.setWifiname(item: WifiData?) {
    item?.let {
        text = item.wifiname
    }
}


@BindingAdapter("setStrengthValue")
fun TextView.setStrengthValue(item: WifiData?){
    item?.let {
        text = item.wifiStrength.toString()
    }
}

@BindingAdapter("setStrengthStatus")
fun TextView.setStrengthStatus(item: WifiData?) {
    item?.let {
        when (item.wifiStrength) {
            in 0 downTo -55 -> text = context.getString(R.string.excellent)
            in -55 downTo -75 -> text = context.getString(R.string.fair)
            in -75 downTo -85 -> text = context.getString(R.string.weak)
            in -85 downTo -100 -> text = context.getString(R.string.poor)
            else -> text = context.getString(R.string.no_signal)
        }
    }
}