package cross_env;

import java.io.IOException;
import java.security.Provider;
import java.util.Properties;

import org.example.cross_env.KotlinClass;
import org.example.cross_env.KotlinClassUtils;
import org.example.cross_env.Singleton;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/**
 * Copyright (C), 2014-2025, 无业游民
 *
 * @ProjectName: KotlinStudy2
 * @Package: cross_env
 * @ClassName: Java2Kotlin
 * @Description:
 * @Author: randysu
 * @CreateDate: 2025/1/30 11:45
 * @UpdateUser:
 * @UpdateDate: 2025/1/30 11:45
 * @UpdateRemark:
 * @Version: 1.0
 *
 * Java 环境下调用 Kotlin 相关内容
 */
public class Java2Kotlin {

    public static void main(String[] args) {

        // Kotlin 属性交互
        KotlinClass kotlinClass = new KotlinClass();
        kotlinClass.getName();
        kotlinClass.setName("newName");

        kotlinClass.isOpen();
        kotlinClass.setOpen(true);

        // 包级函数
//        KotlinClassKt.kotlinFun();
        KotlinClassUtils.kotlinFun();

        // 获取 Kotlin 实例字段
        int kotlinID = kotlinClass.ID;
        System.out.println("kotlinID: " + kotlinID);

        // 获取 Kotlin 静态字段
        String kotlinStaticVal = KotlinClass.TAG;
        System.out.println("kotlinStaticVal: " + kotlinStaticVal);

        // 获取 Kotlin 对象、伴生对象
//        Singleton.properties = new Properties();
//        String mValue = Singleton.properties.getProperty("mKey");
//        System.out.println("mValue: " + mValue);
        Singleton.objStaticFunc();
        Singleton.INSTANCE.objInstanceFunc();

        // 使用 Kotlin 静态方法
        KotlinClass.staticFunc();
        KotlinClass.Companion.instanceFunc();

        // KClass
        KClass<KotlinClass> kClass = JvmClassMappingKt.getKotlinClass(KotlinClass.class);
        String kClassName = kClass.getSimpleName();
        System.out.println("kClassName: " + kClassName);

        // Java 调用 Kotlin 带异常的方法
        try {
            KotlinClassUtils.kotlinFunException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
