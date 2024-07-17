package com.taurunium.rxjavastart

import android.util.Log
import com.taurunium.rxjavastart.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun createObservable(): Observable<Int>{
    return Observable.create{emmiter->
        try {
            if(!emmiter.isDisposed){
                for(i in 0..100){
                    emmiter.onNext(i)
                }
                emmiter.onComplete()
            }
        }catch (e:Exception){
            emmiter.onError(e)
        }

    }
}


fun observer(): Observer<Int>{
    return object: Observer<Int>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: ")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

        override fun onNext(t: Int) {
            Log.d(TAG, "onNext: ")
        }

    }
}