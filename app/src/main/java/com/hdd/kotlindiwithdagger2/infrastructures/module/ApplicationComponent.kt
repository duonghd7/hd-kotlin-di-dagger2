package com.hdd.kotlindiwithdagger2.infrastructures.module

import com.hdd.kotlindiwithdagger2.infrastructures.scope.ApplicationScope
import dagger.Component
import retrofit2.Retrofit

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@ApplicationScope
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun retrofit(): Retrofit
}