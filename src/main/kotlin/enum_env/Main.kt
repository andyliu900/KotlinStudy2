package org.example.enum_env

/**
 * Copyright (C), 2014-2025, 北京百度网讯股份有限公司
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.enum_env
 * @ClassName:      Main
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 15:39
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 15:39
 * @UpdateRemark:
 * @Version:        1.0
 */

enum class Country {
    CN,
    USA
}

fun printCountryWithEnum(country: Country) {
    when (country) {
        Country.CN -> println("中国")
        Country.USA -> println("美国")
    }
}

fun main() {
    printCountryWithEnum(Country.CN)
}