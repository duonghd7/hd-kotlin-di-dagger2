package com.hdd.kotlindiwithdagger2.infrastructures.module

import com.hdd.kotlindiwithdagger2.infrastructures.model.Person
import com.hdd.kotlindiwithdagger2.infrastructures.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@Module
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun providePerson(): Person {
        return Person("Alice", 30)
    }
}