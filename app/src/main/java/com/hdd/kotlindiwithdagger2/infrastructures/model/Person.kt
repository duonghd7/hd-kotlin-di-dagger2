package com.hdd.kotlindiwithdagger2.infrastructures.model

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

class Person(name: String, age: Int) {
    private val name: String
    private val age: Int

    init {
        this.name = name
        this.age = age
    }
}