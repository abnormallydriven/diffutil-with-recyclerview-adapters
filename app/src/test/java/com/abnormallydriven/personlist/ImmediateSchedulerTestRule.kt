package com.abnormallydriven.personlist

import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

//https://gist.github.com/timrijckaert/1b07748bf4757fd401493af750925fbc
class ImmediateSchedulersRule : TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler { _ -> Schedulers.trampoline() }
                RxJavaPlugins.setComputationSchedulerHandler { _ -> Schedulers.trampoline() }
                RxJavaPlugins.setNewThreadSchedulerHandler { _ -> Schedulers.trampoline() }

                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                }
            }
        }
    }
}