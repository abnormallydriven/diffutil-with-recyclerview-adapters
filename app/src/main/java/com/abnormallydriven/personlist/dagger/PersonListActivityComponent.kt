package com.abnormallydriven.personlist.dagger

import com.abnormallydriven.personlist.PersonListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [PersonListActivityModule::class])
interface PersonListActivityComponent : AndroidInjector<PersonListActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PersonListActivity>() {}
}