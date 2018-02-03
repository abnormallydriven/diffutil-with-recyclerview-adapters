package com.abnormallydriven.personlist.dagger

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.abnormallydriven.personlist.PersonListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@Singleton
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelMapKey(PersonListViewModel::class)
    abstract fun bindPersonListViewModel(personListViewModel : PersonListViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(applicationViewModelFactory :ApplicationViewModelFactory) : ViewModelProvider.Factory

}