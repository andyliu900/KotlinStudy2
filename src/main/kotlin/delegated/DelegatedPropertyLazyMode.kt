package org.example.delegated

import org.example.println
import kotlin.concurrent.thread

/**
 * Copyright (C), 2014-2025, 北京百度网讯股份有限公司
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.delegated
 * @ClassName:      DelegatedPropertyLazyMode
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 15:14
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 15:14
 * @UpdateRemark:
 * @Version:        1.0
 */

class DelegatedProperty2 {
    val friends by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("init ------${Thread.currentThread().name}")
        loadFriendList()
    }

    private fun loadFriendList(): String {
        Thread.sleep(10)
        return "AAA${Thread.currentThread().name}"
    }
}

fun main() {
    val d = DelegatedProperty2()
    repeat(4){
        thread(name = "My thread${it}") {
            d.friends.println()
        }
    }

    Thread.sleep(5000)

}