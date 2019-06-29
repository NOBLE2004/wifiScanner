package com.android.wifiscanner.Application


import com.android.wifiscanner.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication



class WifiApplication : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        init()
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

    private fun init() {
       /* if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }*/
    }
}