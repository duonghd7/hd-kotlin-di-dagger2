package com.hdd.kotlindiwithdagger2.domain.second

import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.module.ActivityModule
import com.hdd.kotlindiwithdagger2.infrastructures.module.ApplicationComponent
import com.hdd.kotlindiwithdagger2.infrastructures.scope.ActivityScope
import dagger.Component

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface SecondComponent {
    fun inject(secondActivity: SecondActivity)
}