package com.taurunium.rxjavastart

import android.util.Log
import com.taurunium.rxjavastart.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.Arrays
import java.util.concurrent.TimeUnit


val lista = mutableListOf<Int>(1, 2, 3, 4, 5)
val arrayOf = arrayOf(1, 2, 3, 4, 5)
val arrayOf2 = arrayOf(1, 2, 3, 4, 5)

fun justOperator() {
    val observable = Observable.just(lista)
    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe called: ")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError called: ")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete called: ")
        }

        override fun onNext(t: List<Int>) {
            Log.d(MainActivity.TAG, "onNext called: " + t)
        }

    }

    observable.subscribe(observer)
}


fun fromOperator(){
    val observable = Observable.fromArray(arrayOf)

    val observer = object:Observer<Array<Int>>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: ")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

        override fun onNext(t: Array<Int>) {
            Log.d(TAG, "onNext: ${Arrays.toString(t)}")
        }
    }

    observable.subscribe(observer)
}


fun fromIterable(){
    val observable = Observable.fromIterable(lista)

    val observer = object: Observer<Int>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onComplete() {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: Int) {
            Log.d(TAG, "onNext: "+t)
        }
    }

    observable.subscribe(observer)
}


fun rangeOperator(): Observable<Int>{
    return Observable.range(1, 5)
}


fun repeatOperator(): Observable<Int>{
    return Observable.range(1, 5).repeat(3)
}


fun intervalOperator(): Observable<Long>{
    return Observable.interval(3,2, TimeUnit.SECONDS).takeWhile { value ->
        value <= 10
    }
}

fun getLocation(){
    Log.d(TAG, "currentLocation: 102.22 99.45")
}

fun timerOperator(): Observable<Long>{
    return Observable.timer(5, TimeUnit.SECONDS)
}