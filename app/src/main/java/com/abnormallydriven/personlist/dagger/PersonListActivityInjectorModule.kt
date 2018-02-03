package com.abnormallydriven.personlist.dagger

import android.app.Activity
import com.abnormallydriven.personlist.PersonListActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(PersonListActivityComponent::class))
abstract class PersonListActivityInjectorModule {

    @Binds
    @IntoMap
    @ActivityKey(PersonListActivity::class)
    abstract fun bindInjectorFactory(builder : PersonListActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}