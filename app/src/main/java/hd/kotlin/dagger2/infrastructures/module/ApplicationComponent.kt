package hd.kotlin.dagger2.infrastructures.module

import hd.kotlin.dagger2.infrastructures.model.Person
import hd.kotlin.dagger2.infrastructures.scope.ApplicationScope
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