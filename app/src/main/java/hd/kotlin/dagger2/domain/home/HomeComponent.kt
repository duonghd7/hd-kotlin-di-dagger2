package hd.kotlin.dagger2.domain.home

import hd.kotlin.dagger2.infrastructures.module.ActivityModule
import hd.kotlin.dagger2.infrastructures.module.ApplicationComponent
import hd.kotlin.dagger2.infrastructures.scope.ActivityScope
import dagger.Component

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

@ActivityScope
@Component(
        dependencies = [ApplicationComponent::class],
        modules = [ActivityModule::class])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}