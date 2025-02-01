package org.example.delegated

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * Copyright (C), 2014-2025, 北京百度网讯股份有限公司
 * @ProjectName:    KotlinStudy2
 * @Package:        org.example.delegated
 * @ClassName:      DelegatedPropertyListenerImpl
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/2/1 15:10
 * @UpdateUser:
 * @UpdateDate:     2025/2/1 15:10
 * @UpdateRemark:
 * @Version:        1.0
 */

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport("people")

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty2(
    private var propValue: Int,
    private val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: People3, pro: KProperty<*>): Int = propValue
    operator fun setValue(p: People3, pro: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(pro.name, oldValue, newValue)
    }
}

class People3(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    //通过by实现属性委托，委托给ObservableProperty2
    var age: Int by ObservableProperty2(age, changeSupport)
    var salary: Int by ObservableProperty2(salary, changeSupport)
}

fun testImp3() {
    val p3 = People3("AAA", 38, 74500)
    p3.addPropertyChangeListener(PropertyChangeListener { event ->
        //println("event source: ${event.source}")
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    })
    p3.age += 1
    p3.salary += 1000
}

fun main() {
    testImp3()
}