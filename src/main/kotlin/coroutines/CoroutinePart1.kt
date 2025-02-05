package org.example.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.coroutines
 * @ClassName:      CoroutinePart1
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 23:21
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 23:21
 * @UpdateRemark:
 * @Version:        1.0
 */


fun partTest1() = runBlocking {
    val scope = CoroutineScope(EmptyCoroutineContext)
    scope.launch {
        println("scope: ${Thread.currentThread().name}")
    }

    val scope1 = CoroutineScope(Dispatchers.Default)
    scope1.launch {
        println("scope1: ${Thread.currentThread().name}")
    }

    val scope2 = CoroutineScope(EmptyCoroutineContext)
    scope2.launch(Dispatchers.IO) {
        println("scope2: ${Thread.currentThread().name}")
    }
}

fun partTest2() {
    val context = newFixedThreadPoolContext(4, "MyTHread")
    val scope = CoroutineScope(context)
    scope.launch {
        println("scope: ${Thread.currentThread().name}")
    }
    context.close()
}

fun partTest3() = runBlocking {
//    val scope = CoroutineScope(EmptyCoroutineContext)
//    scope.launch {
        println("step 1")
        withContext(Dispatchers.IO) { withContextFun() }
//        launch(Dispatchers.IO) {
//            delay(100)
//            println("step 2")
//        }
        println("step 3")
//    }
}

suspend fun withContextFun(): String {
    delay(1000L)
    val message = "withContextFun"
    println("step 2 message: ${message}")
    return message
}

fun main() {
    partTest1()
//    partTest2()
//    partTest3()
//    testWithContext()
}



fun testWithContext() = runBlocking {
    var resultOne = "码农乐园"
    var resultTwo = "testWithContext"
    println( "Before")
    resultOne = withContext(Dispatchers.IO) { function1() }
    resultTwo = withContext(Dispatchers.IO) { function2() }
    println( "After")
    val resultText = resultOne + resultTwo
    println( resultText)
}

suspend fun function1(): String
{
    delay(1000L)
    val message = "function1"
    println( message)
    return message
}

suspend fun function2(): String
{
    delay(100L)
    val message = "function2"
    println( message)
    return message
}