package com.taurunium.rxjavastart

import android.util.Log
import com.taurunium.rxjavastart.MainActivity.Companion.TAG
import com.taurunium.rxjavastart.data.User
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

val myUserList = mutableListOf<User>(
    User(1, "User1", 15),
    User(2, "User2", 18),
    User(3, "User3", 23),
    User(4, "User4", 33),
    User(5, "User5", 23),
    User(6, "User6", 23),
    User(7, "User7", 56),
    User(8, "User8", 22),
    User(9, "User9", 22),
)

fun createObservable(): Observable<Int> {
    return Observable.create { emmiter ->
        try {
            if (!emmiter.isDisposed) {
                for (i in 0..100) {
                    emmiter.onNext(i)
                }
                emmiter.onComplete()
            }
        } catch (e: Exception) {
            emmiter.onError(e)
        }

    }
}


fun observer(): Observer<Int> {
    return object : Observer<Int> {
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


fun createSingleObservable(): Single<List<User>> {
    return Single.create { emmiter ->
        try {
            if (!emmiter.isDisposed) {
                emmiter.onSuccess(myUserList)
            }
        } catch (e: Exception) {
            emmiter.onError(e)
        }
    }
}

fun observerSingle(): SingleObserver<List<User>> {
    return object : SingleObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {

        }

        override fun onSuccess(t: List<User>) {
            Log.d(TAG, "onSuccess: " + t)
        }
    }
}


fun createMaybeObservable(): Maybe<List<User>> {
    return Maybe.just(emptyList())
}

fun observerMaybe(): MaybeObserver<List<User>> {
    return object : MaybeObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {

        }

        override fun onComplete() {

        }

        override fun onSuccess(t: List<User>) {
            t?.forEach{
                Log.d(TAG, "onSuccess: "+it)
            }
        }
    }
}

