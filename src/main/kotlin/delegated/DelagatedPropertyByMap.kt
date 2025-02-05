package org.example.delegated

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.delegated
 * @ClassName:      DelagatedPropertyByMap
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 15:34
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 15:34
 * @UpdateRemark:
 * @Version:        1.0
 */

class DelegatedPropertyByMap(val map: Map<String, Any>) {
    val name: String? by map
    val age: Int by map
}

fun main() {
    val delegate = DelegatedPropertyByMap(hashMapOf("age" to 12))
    println(delegate.age)
    println(delegate.name)
}