package com.android.wifiscanner.viewmodel

import androidx.lifecycle.ViewModel
import com.android.wifiscanner.entity.database.WifiData
import com.android.wifiscanner.repository.WifiScanRepository
import kotlinx.coroutines.*

class MainActivityViewModel(val wifiScanRepository: WifiScanRepository) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val getScanResult = wifiScanRepository.getAllResults()


    fun startMonitoring(listData: WifiData) {
        uiScope.launch {
            insertData(listData)
        }
    }

    suspend fun insertData(listData: WifiData) {
        withContext(Dispatchers.IO) {
            wifiScanRepository.insert(listData)
        }
    }

    fun removeTestData(ssid: String) {
        uiScope.launch {
            delete(ssid)
        }
    }

    suspend fun delete(ssid: String) {
        withContext(Dispatchers.IO) {
            wifiScanRepository.delete(ssid)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun isGranted(ispermissionGranted: Boolean) {
        wifiScanRepository.checkStoragePermission(ispermissionGranted)
    }

}