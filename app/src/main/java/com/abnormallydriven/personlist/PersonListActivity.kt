package com.abnormallydriven.personlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.abnormallydriven.personlist.dagger.ApplicationViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_person_list.*
import javax.inject.Inject

class PersonListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ApplicationViewModelFactory

    @Inject
    lateinit var personListAdapter: PersonListAdapter

    lateinit var viewModel: PersonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        personListRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        personListRecyclerView.adapter = personListAdapter

        swipeToRefreshLayout.setOnRefreshListener {
            viewModel.loadLatestData()
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PersonListViewModel::class.java)

        if (savedInstanceState == null) {
            viewModel.loadLatestData()
        }

        viewModel.getPersonList().observe(this, Observer<List<Person>> { personList: List<Person>? ->
            if (personList == null) {
                return@Observer
            }

            personListAdapter.updateAdapter(personList)
            swipeToRefreshLayout.isRefreshing = false
        })
    }

}
