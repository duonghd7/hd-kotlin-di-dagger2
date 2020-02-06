package hd.kotlin.dagger2

import android.app.Application
import hd.kotlin.dagger2.infrastructures.module.ApplicationComponent
import hd.kotlin.dagger2.infrastructures.module.ApplicationModule
import hd.kotlin.dagger2.infrastructures.module.DaggerApplicationComponent

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

open class MainApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule())
                .build()
    }
}