package com.hdd.kotlindiwithdagger2.domain.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.hdd.kotlindiwithdagger2.MainApplication
import com.hdd.kotlindiwithdagger2.R
import com.hdd.kotlindiwithdagger2.domain.second.SecondActivity
import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.module.ActivityModule
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

open class HomeActivity : Activity() {
    @Inject
    lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        DaggerHomeComponent.builder().applicationComponent(MainApplication.applicationComponent)
                .activityModule(ActivityModule())
                .build().inject(this)

        activity_home_tv_content.text = person.toString()

        activity_home_tv_hello.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
