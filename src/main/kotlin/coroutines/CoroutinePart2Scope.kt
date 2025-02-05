package org.example.coroutines

import kotlinx.coroutines.*
import sun.invoke.empty.Empty
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.coroutines
 * @ClassName:      CoroutinePart2Scope
 * @Description:    CoroutineScope 与 CoroutineContext
 * @Author:         randysu
 * @CreateDate:     2025/2/3 19:49
 * @UpdateUser:
 * @UpdateDate:     2025/2/3 19:49
 * @UpdateRemark:
 * @Version:        1.0
 */

//fun main() = runBlocking {
//    val scope = CoroutineScope(EmptyCoroutineContext)
//    val job = scope.launch {
//        println("DIspatcher: ${coroutineContext[ContinuationInterceptor]}")
//    }
//    job.join()
//}

//fun main() = runBlocking {
//    val scope = CoroutineScope(EmptyCoroutineContext)
//    val job = scope.launch {
//        val resule = coroutineScope {
//            val deferred1 = async { "Coroutine" }
//            val deferred2 = async { "Scope" }
//            deferred1.await() + deferred2.await()
//        }
//        println("result: $resule")
//    }
//    job.join()
//}

fun main() = runBlocking {
    val scope = CoroutineScope(EmptyCoroutineContext)
    val job = scope.launch {
        val result = try {
            coroutineScope {
                val deferred1 = async { "Coroutine" }
                val deferred2 = async { throw RuntimeException("Error!") }
                deferred1.await() + deferred2.await()
            }
        } catch (e: Exception) {
            e.message
        }
        println("result: $result")
    }
    job.join()
}