package org.example.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.coroutines
 * @ClassName:      CoroutinePart5FlowOperator
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/4 16:11
 * @UpdateUser:
 * @UpdateDate:     2025/2/4 16:11
 * @UpdateRemark:
 * @Version:        1.0
 */


fun main() = runBlocking<Unit> {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val flow = flowOf(1, 2, 3, 4, 5)
    val job = scope.launch {
        flow.onEach {
            println("onEach: $it")
        }.onEach {
            println("onEach2: ${it * 2}")
            it * 2
        }.collect {
            println("result: ${it}")
        }
    }
    job.join()
}
