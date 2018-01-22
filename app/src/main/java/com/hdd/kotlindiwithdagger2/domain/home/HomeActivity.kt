package com.hdd.kotlindiwithdagger2.domain.home

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.TextView
import com.hdd.kotlindiwithdagger2.MainApplication
import com.hdd.kotlindiwithdagger2.R
import com.hdd.kotlindiwithdagger2.domain.second.SecondActivity_
import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.module.ActivityModule
import org.androidannotations.annotations.*
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@SuppressLint("Registered")
@EActivity(R.layout.activity_home)
open class HomeActivity : Activity() {
    @App
    lateinit var mainApplication: MainApplication

    @Inject lateinit var retrofit: Retrofit
    @Inject lateinit var person: Person

    @AfterInject
    fun afterInject() {
        DaggerHomeComponent.builder()
                .applicationComponent(mainApplication.getApplicationComponent())
                .activityModule(ActivityModule(this))
                .build().inject(this)
    }

    @AfterViews
    fun afterViews() {
        Log.e("test", "ok")
    }

    @Click(R.id.activity_home_tv_hello)
    fun tvHelloClick() {
        SecondActivity_.intent(this).start()
    }
}
