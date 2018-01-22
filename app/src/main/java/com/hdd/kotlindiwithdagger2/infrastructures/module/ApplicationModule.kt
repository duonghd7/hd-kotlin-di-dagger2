package com.hdd.kotlindiwithdagger2.infrastructures.module

import android.app.Application
import android.content.Context
import com.hdd.kotlindiwithdagger2.ApiURLs.Companion.ROOT_URL
import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@Module
class ApplicationModule(val app: Application) {
    @Provides
    @ApplicationScope
    fun provideContext(): Context {
        return app
    }

    @Provides
    @ApplicationScope
    fun provideApplication(): Application {
        return app
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
    }

    @Provides
    @ApplicationScope
    fun providePerson(): Person {
        return Person("Alice", 30)
    }
}