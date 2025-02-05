package org.example.delegated

import kotlin.reflect.KProperty

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.delegated
 * @ClassName:      DelegatedPropertyBy
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 12:56
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 12:56
 * @UpdateRemark:
 * @Version:        1.0
 */

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example {
    var p: String by Delegate()

    // setter  ->  setValue
    // getter  ->  getValue
}

fun main() {

    val e = Example()
    e.p = "AAA"
    println(e.p)
}