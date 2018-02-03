package com.abnormallydriven.personlist

import android.content.res.Resources
import io.reactivex.Single
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonService @Inject constructor(private val resources: Resources) {

    private val random: Random = Random(System.currentTimeMillis())
    private val fakeNameList: MutableList<String> = mutableListOf()
    private val fakeStatusList: List<String> = listOf("Busy",
            "AFK",
            "In Chat",
            "In Game",
            "BRB")

    fun getPersonList(): Single<List<Person>> {

        if (fakeNameList.isEmpty()) {
            initializeFakeNameList()
        }

        val currentPersonList = mutableListOf<Person>()

        fakeNameList.forEachIndexed { index, name ->
            currentPersonList.add(createFakePerson(index, name))
        }

        return Single.just(currentPersonList.toList())
                .delay(random.nextInt(500).toLong(), TimeUnit.MILLISECONDS)
    }

    private fun createFakePerson(personId: Int, name: String): Person {
        return Person(personId,
                name,
                random.nextBoolean(),
                fakeStatusList[random.nextInt(fakeStatusList.size)]
        )
    }

    private fun initializeFakeNameList() {
        val rawInputStream = resources.openRawResource(R.raw.fake_name_list)
        val reader = InputStreamReader(rawInputStream)
        val bufferedReader = BufferedReader(reader)

        fakeNameList.addAll(bufferedReader.readLines())
    }

}