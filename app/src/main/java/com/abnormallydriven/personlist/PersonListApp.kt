package com.abnormallydriven.personlist

import com.abnormallydriven.personlist.dagger.DaggerPersonListApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class PersonListApp : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerPersonListApplicationComponent.builder()
                .application(this)
                .build()
    }

}