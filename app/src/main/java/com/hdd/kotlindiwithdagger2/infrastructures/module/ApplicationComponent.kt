package com.hdd.kotlindiwithdagger2.infrastructures.module

import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.scope.ApplicationScope
import dagger.Component

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun person(): Person
}