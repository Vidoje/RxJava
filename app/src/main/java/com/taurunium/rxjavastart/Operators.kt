package com.taurunium.rxjavastart

import android.util.Log
import com.taurunium.rxjavastart.MainActivity.Companion.TAG
import com.taurunium.rxjavastart.data.User
import com.taurunium.rxjavastart.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.Arrays
import java.util.concurrent.TimeUnit


val lista = mutableListOf<Int>(1, 2, 3, 4, 5)
val arrayOf = arrayOf(1, 2, 3, 4, 5)
val arrayOf2 = arrayOf(1, 2, 3, 4, 5)
val mUserList = mutableListOf<User>(
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

val mUserProfileList = mutableListOf<UserProfile>(
    UserProfile(1, "User1", 15, ""),
    UserProfile(2, "User2", 18, ""),
    UserProfile(3, "User3", 23, ""),
    UserProfile(4, "User4", 33, ""),
    UserProfile(5, "User5", 23, ""),
    UserProfile(6, "User6", 23, ""),
    UserProfile(7, "User7", 56, ""),
    UserProfile(8, "User8", 22, ""),
    UserProfile(9, "User9", 22, ""),
)

val mUserListGroupBy = mutableListOf<User>(
    User(1, "User1", 33),
    User(2, "User2", 18),
    User(3, "User3", 18),
    User(4, "User4", 33),
    User(5, "User5", 33),

)


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

fun fromOperator() {
    val observable = Observable.fromArray(arrayOf)

    val observer = object : Observer<Array<Int>> {
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

fun fromIterable() {
    val observable = Observable.fromIterable(lista)

    val observer = object : Observer<Int> {
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
            Log.d(TAG, "onNext: " + t)
        }
    }

    observable.subscribe(observer)
}

fun rangeOperator(): Observable<Int> {
    return Observable.range(1, 5)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1, 5).repeat(3)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(3, 2, TimeUnit.SECONDS).takeWhile { value ->
        value <= 10
    }
}

fun getLocation() {
    Log.d(TAG, "currentLocation: 102.22 99.45")
}

fun timerOperator(): Observable<Long> {
    return Observable.timer(5, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create(ObservableOnSubscribe<Int> {
        try {
            for (i in lista) {
                it.onNext(i * 5)
            }
            it.onComplete()
        } catch (e: Exception) {
            it.onError(e)
        }
    })
}

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun lastOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun skipOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun bufferOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun mapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun flatMapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUserProfile(id: Long): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
        .filter {
            it.id == id
        }
}


fun groupByOperator(): Observable<User> {
    return Observable.fromIterable(mUserListGroupBy)
}


fun getUserProfiles(): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
}

fun getUsers(): Observable<User>{
    return Observable.fromIterable(mUserList)
}

fun mergeOperator(): Observable<Any>{
    return Observable.merge(getUsers(), getUserProfiles())
}

fun getFrom1To10(): Observable<Int>{
    return Observable.range(1, 10)
}

fun getFrom11To20(): Observable<Int>{
    return Observable.range(11,20)
}

fun concatOperator(): Observable<Int>{
    return Observable.concat(getFrom1To10(), getFrom11To20())
}