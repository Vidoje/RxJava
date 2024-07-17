package com.taurunium.rxjavastart

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.taurunium.rxjavastart.data.User
import com.taurunium.rxjavastart.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        timerOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: "+it)
//                getLocation()
//            },
//            {
//                Log.d(TAG, "onError: "+it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })

//        createOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: "+it)
//            },
//            {
//                Log.d(TAG, "onError: "+it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })

//        filterOperator().filter {
//            it.age > 23
//        }.subscribe(
//            {
//                Log.d(TAG, "onNext: " + it)
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            }
//        )

//        lastOperator().last(User(111, "default",11)).subscribe(
//            {
//                Log.d(TAG, "onNext: " + it)
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            }
//        )
//
//        distinctOperator().distinct {
//            it.age
//        }.subscribe(
//            {
//                Log.d(TAG, "onNext: " + it)
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })

//        bufferOperator().buffer(2).subscribe(
//            {
//                Log.d(TAG, "onNext: " + it)
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })
//
//        mapOperator().map {
//            UserProfile(it.id, it.name, it.age, "")
//        }.subscribe(
//            {
//                Log.d(TAG, "onNext: " + it)
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })


//        flatMapOperator().flatMap {
//            getUserProfile(it.id)
//        }.subscribe(
//            {
//                Log.d(TAG, "onNext: " + it)
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })

//        groupByOperator().groupBy {
//            it.age
//        }.subscribe(
//            {
//                group->
//                    group.subscribe({
//                        Log.d(TAG, "${group.key}: value ${it} ")
//                    },
//                        {
//
//                        })
//            },
//            {
//                Log.d(TAG, "onError: " + it)
//            },
//            {
//                Log.d(TAG, "onComplete: ")
//            })

        mergeOperator().subscribe({
            Log.d(TAG, "lista  "+it)
        })
    }
}