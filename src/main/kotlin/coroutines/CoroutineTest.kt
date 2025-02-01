package org.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Copyright (C), 2021-2025, 百度阿波罗
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example
 * @ClassName:      CoroutineTest
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/29 13:47
 * @UpdateUser:
 * @UpdateDate:     2025/1/29 13:47
 * @UpdateRemark:
 * @Version:        1.0
 */

fun main() {
//    test1()
//    test2()
//    test3()
//    test4()
//    test5()
    test6()
}

fun test1() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello ")
    Thread.sleep(2000L)
}

fun test2() = runBlocking {
    repeat(100) {
        println("Hello")
    }
}

fun test3() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello ")
    delay(2000L)
}

fun test4() = runBlocking {
    val job = launch {
        costTimeFun()
    }
    println("Hello ")
    job.join()
}

suspend fun costTimeFun() {
    delay(1000L)
    println("World!")
}

fun test5() = runBlocking {
    val startTime = System.currentTimeMillis()
    val one = itemOne()
    val two = itemTwo()
    println("The items is ${one} and ${two}")

    val dexTime = System.currentTimeMillis() - startTime
    println("Cost time ${dexTime}")
}

fun test6() = runBlocking {
    println("mainThread: ${Thread.currentThread().name}")
    val startTime = System.currentTimeMillis()
    val one = async { itemOne() }
    val two = async { itemTwo() }
    println("The items is ${one.await()} and ${two.await()}")

    val dexTime = System.currentTimeMillis() - startTime
    println("Cost time ${dexTime}")
}

suspend fun itemOne(): String {
    println("oneThread: ${Thread.currentThread().name}")
    delay(1000L)
    return "item-one"
}

suspend fun itemTwo(): String {
    println("twoThread: ${Thread.currentThread().name}")
    delay(1000L)
    return "item-two"
}
