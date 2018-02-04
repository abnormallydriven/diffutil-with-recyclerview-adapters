package com.abnormallydriven.personlist.dagger

import com.abnormallydriven.personlist.PersonListApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationResourcesModule::class,
    AndroidInjectionModule::class,
    PersonListActivityInjectorModule::class,
    ViewModelModule::class])
interface PersonListApplicationComponent : AndroidInjector<PersonListApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application : PersonListApp) : Builder
        fun build() : PersonListApplicationComponent
    }

}