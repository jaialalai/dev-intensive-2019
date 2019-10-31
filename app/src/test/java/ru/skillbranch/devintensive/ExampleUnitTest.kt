package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_users() {
        val user1 = User("1")
        val user2 = User("2", "John", "Wick")
        val user3 =
            User("3", "John", "Snow", null, lastVisit = Date(), isOnline = true)

        user1.printMe()
        user3.printMe()

        println("$user1 $user2 $user3")
    }

    @Test
    fun test_factory() {
        val user1 = User.makeUser("John Doe")
        val user2 = User.makeUser("John Snow")

        println("$user1 $user2")

    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Doe")
        val user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Wick", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())

    }

    @Test
    fun test_dara_mapping() {
        val user = User.makeUser("Макеев Михаил")

        println(user)
        val userView = user.toUserView()

        userView.printMe()
    }
}