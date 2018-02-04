package com.abnormallydriven.personlist

import com.abnormallydriven.personlist.dagger.DaggerPersonListApplicationComponent
import com.abnormallydriven.personlist.dagger.PersonListApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


//TODO implement the diff util with payload changes
//TODO compare diff util move detection vs no move detection
//TODO compare diff util vs normal notify data set changed

class PersonListApp : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component : PersonListApplicationComponent = DaggerPersonListApplicationComponent.builder()
                .application(this)
                .build()

        return component
    }

}