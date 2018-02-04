package com.abnormallydriven.personlist.dagger

import android.content.res.Resources
import com.abnormallydriven.personlist.PersonListApp
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Module
class ApplicationResourcesModule {


    @Provides
    @Singleton
    fun provideResources(personListApp: PersonListApp) : Resources{
        return personListApp.resources
    }

    @Provides
    @Singleton
    @UI
    fun provideMainThreadScheduler() : Scheduler{
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    @IO
    fun provideIoScheduler() : Scheduler{
        return Schedulers.io()
    }


    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UI

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    annotation class IO

}