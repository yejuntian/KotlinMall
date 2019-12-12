package com.kotlin.baselibrary.ext

import com.kotlin.baselibrary.rx.BaseSubscriber
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>) {
    return this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}


