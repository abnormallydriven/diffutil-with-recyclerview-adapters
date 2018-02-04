package com.abnormallydriven.personlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.NonNull
import com.abnormallydriven.personlist.dagger.ApplicationResourcesModule
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonListViewModel @Inject constructor(private val personService: PersonService,
                                              @ApplicationResourcesModule.UI private val uiScheduler : Scheduler,
                                              @ApplicationResourcesModule.IO private val ioScheduler : Scheduler) : ViewModel() {

    private val personList : MutableLiveData<List<Person>> = MutableLiveData()

    init {
        personList.value = listOf()
    }

    fun loadLatestData() {
        personService.getPersonList()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe(object : SingleObserver<List<Person>> {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onError(e: Throwable) {}

                    override fun onSuccess(updatedPersonList: List<Person>) {
                        personList.value = updatedPersonList
                    }
                })
    }


    fun getPersonList() : LiveData<List<Person>> {
        return personList
    }

    override fun onCleared() {
        personList.value = listOf()
    }
}