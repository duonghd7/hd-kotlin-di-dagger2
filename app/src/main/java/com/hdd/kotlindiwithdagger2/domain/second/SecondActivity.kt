package com.hdd.kotlindiwithdagger2.domain.second

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.widget.TextView
import com.hdd.kotlindiwithdagger2.MainApplication
import com.hdd.kotlindiwithdagger2.R
import com.hdd.kotlindiwithdagger2.infrastructures.module.ActivityModule
import org.androidannotations.annotations.*
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@SuppressLint("Registered")
@EActivity(R.layout.activity_second)
open class SecondActivity : Activity() {
    @App
    lateinit var mainApplication: MainApplication

    @ViewById(R.id.activity_second_tv_back)
    protected lateinit var tvHello: TextView

    @Inject lateinit var retrofit: Retrofit

    @AfterInject
    fun afterInject() {
        DaggerSecondComponent.builder()
                .applicationComponent(mainApplication.getApplicationComponent())
                .activityModule(ActivityModule(this))
                .build().inject(this)
    }

    @AfterViews
    fun afterViews() {
        Log.e("test", "ok")
    }

    @Click(R.id.activity_second_tv_back)
    fun tvHelloClick() {
        onBackPressed()
    }

    override fun onBackPressed() {
        finish()
    }
}