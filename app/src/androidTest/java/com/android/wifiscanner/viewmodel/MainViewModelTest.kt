package com.android.wifiscanner.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.wifiscanner.Application.WifiApplication
import com.android.wifiscanner.entity.database.WifiData
import com.android.wifiscanner.entity.database.WifiDatabase
import com.android.wifiscanner.repository.WifiScanRepository
import com.android.wifiscanner.utils.observeOnce
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var mainViewModel: MainActivityViewModel
    lateinit var result: WifiData
    lateinit var repository: WifiScanRepository
    private lateinit var db: WifiDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        val application = requireNotNull(context) as WifiApplication

        db = Room.inMemoryDatabaseBuilder(
            context, WifiDatabase::class.java
        ).build()
        repository = WifiScanRepository(application,db)
        this.mainViewModel = MainActivityViewModel(repository)
        buildScanResult("nobleabc", -50)

    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        runBlocking {
            mainViewModel.delete(result.wifiname)
        }
    }

    private fun buildScanResult(ssid: String, level: Int) {
        result = WifiData(ssid, level)
    }

    @Test
    @Throws(Exception::class)
    fun startMonitoring() {
        runBlocking {
            mainViewModel.insertData(result)
        }

        this.mainViewModel.getScanResult.observeOnce {
            Assert.assertEquals(it.last().wifiname, result.wifiname)
        }
    }
}
