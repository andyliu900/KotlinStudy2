package org.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.coroutines
 * @ClassName:      CoroutinePart4Flow
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/3 23:37
 * @UpdateUser:
 * @UpdateDate:     2025/2/3 23:37
 * @UpdateRemark:
 * @Version:        1.0
 */

//fun main() = runBlocking {
//    val numFlow = flow<Int> {
//        emit(1)
//        emit(2)
//    }.map { "number: ${it}" }
//
//    val scope = CoroutineScope(EmptyCoroutineContext)
//    scope.launch {
//        numFlow.collect {
//            println(it)
//        }
//    }
//
//    delay(3000)
//}

//fun main() = runBlocking{
//    val numFlow = flow<Int> {
//        emit(1)
//        delay(100)
//        emit(2)
//    }
//
//    val scope = CoroutineScope(EmptyCoroutineContext)
//    scope.launch {
//        numFlow.collect {
//            println("A: ${it}")
//        }
//    }
//
//    scope.launch {
//        delay(50)
//        numFlow.collect {
//            println("B: ${it}")
//        }
//    }
//
//    delay(3000)
//}

// 消费数据独立方法
suspend fun showWeather(flow: Flow<String>) = flow.collect {
    println("Weather: ${it}")
}

// 生产数据独立方法
var index = 0
suspend fun getWeather() = withContext(Dispatchers.IO) {
    // 每隔1秒生产一次数据
    // 就算每隔1秒生产一次数据，但根据Flow的特性，依然是 collect 执行收集之后，才会触发 flow 中的挂起函数的逻辑
    delay(1000)
    index++
    println("index: ${index}")
    if (index % 2 == 0) {
        "Sunny"
    } else {
        "Rain"
    }
}

fun main() = runBlocking{
    val scope = CoroutineScope(EmptyCoroutineContext)
    val weatherFlow = flow<String> {
        while (isActive) {
            emit(getWeather())
            // 每隔3秒获取一次数据
            delay(3000)
        }
    }

    val job = scope.launch {
        showWeather(weatherFlow)
    }

    job.join()
}