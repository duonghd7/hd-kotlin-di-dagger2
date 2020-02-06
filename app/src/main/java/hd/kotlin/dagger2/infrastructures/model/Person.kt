package hd.kotlin.dagger2.infrastructures.model

/**
 * Created on 1/22/2018.
 * @author duonghd
 */

class Person(val name: String, val age: Int) {

    override fun toString(): String {
        return "{\n\"name\": $name,\n\"age\": $age\n}"
    }
}