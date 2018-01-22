package com.hdd.kotlindiwithdagger2

import android.annotation.SuppressLint
import android.app.Application
import com.hdd.kotlindiwithdagger2.infrastructures.module.ApplicationComponent
import com.hdd.kotlindiwithdagger2.infrastructures.module.ApplicationModule
import com.hdd.kotlindiwithdagger2.infrastructures.module.DaggerApplicationComponent
import org.androidannotations.annotations.EApplication

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@SuppressLint("Registered")
@EApplication
open class MainApplication : Application() {
    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    open fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}