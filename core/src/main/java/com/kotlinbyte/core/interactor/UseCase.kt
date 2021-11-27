package com.kotlinbyte.core.interactor

import com.kotlinbyte.core.exception.Failure
import com.github.kittinunf.result.Result
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase<out Type, in Params>(private val context: CoroutineContext) where Type : Any {

    abstract suspend fun run(params: Params): Result<Type, Failure>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Result<Type, Failure>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(context) {
                run(params)
            }

            onResult(deferred.await())
        }
    }


    class None

}