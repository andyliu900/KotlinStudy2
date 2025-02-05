package org.example.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.coroutines
 * @ClassName:      CoroutinesBasic
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/30 23:59
 * @UpdateUser:
 * @UpdateDate:     2025/1/30 23:59
 * @UpdateRemark:
 * @Version:        1.0
 */

fun main() = runBlocking {
//    doWorld()
//    println("Done")

    jobTest()
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

fun jobTest() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
    println("job  isActive: ${job.isActive}  isCompleted: ${job.isCompleted}  isCancelled: ${job.isCancelled}")
    job.join() // 等待 job 协程运行结束后，才会执行后面的逻辑
    println("job  isActive: ${job.isActive}  isCompleted: ${job.isCompleted}  isCancelled: ${job.isCancelled}")
    println("Done")
}