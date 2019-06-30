package com.android.wifiscanner.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.wifiscanner.repository.WifiScanRepository


class ViewModelFactory(
    private val repository: WifiScanRepository): ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
