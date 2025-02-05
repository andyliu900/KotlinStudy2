package org.example.cross_env

import cross_env.JavaArrayExample

/**
 * Copyright (C), 2014-2025, 无业游民
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.cross_env
 * @ClassName:      Kotlin2Java
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/29 20:42
 * @UpdateUser:
 * @UpdateDate:     2025/1/29 20:42
 * @UpdateRemark:
 * @Version:        1.0
 *
 *
 * Kotlin 环境下调用 Java 相关内容
 */


fun main() {
//    controlArray()
//    controlArrayVarArg()
//    getJavaClass()
    getJavaStaticPro()
}

fun demo(source: List<Int>) {
    val list = ArrayList<Int>()
    for (item in source) {
        list.add(item)
    }

    for (i in 0..source.size - 1) {
        list[i] = source[i]
    }

    source.forEach {
        list.add(it)
    }
}

fun controlArray() {
    val javaObj = JavaArrayExample()
    val array = intArrayOf(0,1,2,3)
    println("controlArray: ${array.size}")
    javaObj.removeIndices(array)
}

fun controlArrayVarArg() {
    val javaObj = JavaArrayExample()
    val array = intArrayOf(0,1,2,3)
    println("controlArrayVarArg: ${array.size}")
    javaObj.removeIndicesVarArg(*array)
}

fun getJavaClass() {
    val clazz = JavaArrayExample::class.java

    val javaObj = JavaArrayExample()
    val clazz2 = javaObj.javaClass

    println("clazz: ${clazz.name} ${clazz.`package`}  clazz2: ${clazz2.name} ${clazz2.`package`}")
}

fun getJavaStaticPro() {
    val staticVal = JavaArrayExample.STATIC_VAL
    println("staticVal: ${staticVal}")
}

//external fun getValFromJNI(): Int {
//    return 0
//}
