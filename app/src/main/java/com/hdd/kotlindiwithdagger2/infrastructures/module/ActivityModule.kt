package com.hdd.kotlindiwithdagger2.infrastructures.module

import android.app.Activity
import android.content.Context
import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.scope.ActivityScope
import com.hdd.kotlindiwithdagger2.infrastructures.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@Module
class ActivityModule(val act: Activity) {
    @Provides
    @ActivityScope
    fun provideContext(): Context {
        return act
    }

    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return act
    }
}