package com.hdd.kotlindiwithdagger2.domain.second

import android.app.Activity
import android.os.Bundle
import com.hdd.kotlindiwithdagger2.MainApplication
import com.hdd.kotlindiwithdagger2.R
import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.module.ActivityModule
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

class SecondActivity : Activity() {
    @Inject
    lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        DaggerSecondComponent.builder().applicationComponent(MainApplication.applicationComponent)
                .activityModule(ActivityModule())
                .build().inject(this)

        activity_second_tv_content.text = person.toString()

        activity_second_tv_back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}