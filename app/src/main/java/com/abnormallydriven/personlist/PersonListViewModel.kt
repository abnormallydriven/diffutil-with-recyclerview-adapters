package com.abnormallydriven.personlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PersonListViewModel constructor(private val personService: PersonService) : ViewModel() {

    private val personList : MutableLiveData<List<Person>> = MutableLiveData()

    init {
        personList.value = listOf()
    }

    fun loadLatestData() {
        personService.getPersonList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
}