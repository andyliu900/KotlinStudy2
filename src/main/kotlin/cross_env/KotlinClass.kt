
@file:JvmName("KotlinClassUtils")

package org.example.cross_env

import java.io.IOException
import java.util.Properties
import kotlin.jvm.Throws

/**
 * Copyright (C), 2014-2025, 北京百度网讯股份有限公司
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.cross_env
 * @ClassName:      KotlinClass
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/30 11:39
 * @UpdateUser:
 * @UpdateDate:     2025/1/30 11:39
 * @UpdateRemark:
 * @Version:        1.0
 */
class KotlinClass : Cloneable {

    var name: String? = ""
    var isOpen: Boolean? = false

    @JvmField val ID = 1

    companion object {
        @JvmField
        val TAG = "KotlinClass"

        @JvmStatic
        fun staticFunc() {
            println("KotlinClass  staticFunc")
        }

        fun instanceFunc() {
            println("KotlinClass  instanceFunc")
        }
    }

    override fun clone(): Any {
        return super.clone()
    }



}

fun kotlinFun() {
    println("Kotlin Func")
}

@Throws(IOException::class)
fun kotlinFunException() {
    println("kotlinFunException")
    throw IOException()
}

object Singleton {
//    lateinit var properties: Properties
//
//    init {
//        properties.setProperty("mKey", "mValue")
//    }

    @JvmStatic fun objStaticFunc() {
        println("Singleton  objStaticFunc")
    }

    fun objInstanceFunc() {
        println("Singleton  objInstanceFunc")
    }
}