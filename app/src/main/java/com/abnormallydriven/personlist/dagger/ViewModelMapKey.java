package com.abnormallydriven.personlist.dagger;



import android.arch.lifecycle.ViewModel;

import dagger.MapKey;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
public @interface ViewModelMapKey {
    Class<? extends ViewModel> value();
}
