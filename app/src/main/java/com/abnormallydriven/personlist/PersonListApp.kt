package com.abnormallydriven.personlist

import com.abnormallydriven.personlist.dagger.DaggerPersonListApplicationComponent
import com.abnormallydriven.personlist.dagger.PersonListApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class PersonListApp : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component : PersonListApplicationComponent = DaggerPersonListApplicationComponent.builder()
                .application(this)
                .build()

        return component
    }

}