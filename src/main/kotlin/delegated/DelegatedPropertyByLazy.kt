package org.example.delegated

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.delegated
 * @ClassName:      DelegatedPropertyByLazy
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 14:47
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 14:47
 * @UpdateRemark:
 * @Version:        1.0
 */

class DelegatedProperty {
    val friends by lazy {
        loadFriendList()
    }

    private fun loadFriendList(): List<String> {
        return listOf("pony", "johnny", "jack")
    }
}

fun main(args: Array<String>) {
    println(DelegatedProperty().friends)
}

