package org.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.coroutines
 * @ClassName:      CoroutinePart3Channel
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/3 20:10
 * @UpdateUser:
 * @UpdateDate:     2025/2/3 20:10
 * @UpdateRemark:
 * @Version:        1.0
 */


//fun main() = runBlocking {
//    val scope = CoroutineScope(EmptyCoroutineContext)
//    val receiveChannel = scope.produce {
//        while (isActive) {
//            val data = "send message"
//            send(data)
//        }
//    }
//
//    launch {
//        delay(1000L)
//        while (isActive) {
//            println("receive data: ${receiveChannel.receive()}")
//        }
//    }
//
//    delay(3000L)
//}

fun main() = runBlocking {
    val scope = CoroutineScope(EmptyCoroutineContext)
    val channel = Channel<String>()

    scope.launch {
        while (isActive) {
            channel.send("send data")
        }
    }

    scope.launch {
        println("receive 1: ${channel.receive()}")
    }

    scope.launch {
        println("receive 2: ${channel.receive()}")
    }

//    channel.close()
    delay(3000)
}