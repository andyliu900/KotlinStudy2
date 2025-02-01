package org.example.file_io

import java.io.File

/**
 * Copyright (C), 2014-2025, 北京百度网讯股份有限公司
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.file_io
 * @ClassName:      Main
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 16:02
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 16:02
 * @UpdateRemark:
 * @Version:        1.0
 */

val file = File("KotlinStudy2/src/main/kotlin//file_io/file.txt")

fun testWrite() {
    file.writeBytes("AAA writeBytes\n".toByteArray())
    //file.writeText("AAA writeText\n")
    file.appendBytes("AAA appendBytes\n".toByteArray())
    file.appendText("AAA appendText\n")
//    file.outputStream().use {
//        it.write("AAA outputStream\n".toByteArray())
//    }
//    file.printWriter().use {
//        it.println("AAA printWriter")
//    }
//    file.bufferedWriter().use {
//        it.write("AAA")
//    }

}

fun testRead() {
    println("forEachLine-------------------->")
    file.forEachLine{
        println(it)
    }
    println("forEachBlock-------------------->")
    file.forEachBlock { buffer: ByteArray, _: Int ->
        print(buffer.decodeToString())
    }
    println("inputStream-------------------->")
    file.inputStream().use {
        var value: Int = it.read()
        while (value != -1) {
            print(value.toChar())
            value = it.read()
        }
    }
    println("inputStream buffer-------------------->")
    file.inputStream().use {
        val byteArray = ByteArray(1024)
        var value: Int = it.read(byteArray,0,byteArray.size)
        while (value != -1) {
            print(byteArray.decodeToString())
            value = it.read(byteArray,0,byteArray.size)
        }
    }
    println("bufferedReader-------------------->")
    file.bufferedReader().use {
        it.readLines().forEach(::println)
    }


}

fun testOther(){
    // 文件后缀
    println(file.extension)

    // 文件名
    println(file.nameWithoutExtension)

    // 遍历文件夹
    file.parentFile.parentFile
        //.walk()// 先访问文件夹，再访问它文件夹里的内容
        .walkBottomUp()// 先访问文件，再访问它文件夹
        .maxDepth(2) // 访问深度
        //.filter {it.extension.equals("txt",true)  }
        .forEach(::println)

    // 文件拷贝
    file.copyTo(File(file.parent,"copy.txt"), overwrite = true)

    // 文件夹拷贝
    file.parentFile.copyRecursively(File(file.parentFile.parentFile.parentFile.parent,"copyRecursively"),true)
}


fun main() {
    testWrite()
//    testRead()
//    testOther()
}
