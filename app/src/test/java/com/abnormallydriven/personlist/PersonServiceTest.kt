package com.abnormallydriven.personlist

import android.content.res.Resources
import io.reactivex.internal.schedulers.ImmediateThinScheduler
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PersonServiceTest {

    @Rule
    @JvmField
    val immediateSchedulerTestRule = ImmediateSchedulersRule()

    @Test
    fun getPersonList() {

        val testInputStream = javaClass.classLoader.getResourceAsStream("fake_name_list")
        val mockResources = mock(Resources::class.java)

        `when`(mockResources.openRawResource(R.raw.fake_name_list))
                .thenReturn(testInputStream)

        val objectUnderTest = PersonService(mockResources)
        val testObserver = TestObserver<List<Person>>()

        objectUnderTest.getPersonList()
                .subscribe(testObserver)


        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertValue { personList: List<Person> ->
            personList.size == 100
        }
    }

}