package com.abnormallydriven.personlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import javax.inject.Inject

class PersonListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel : PersonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)
    }
}
