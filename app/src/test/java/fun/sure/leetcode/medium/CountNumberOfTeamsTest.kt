package `fun`.sure.leetcode.medium

import kotlinx.coroutines.*
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by wangshuo on 2020/7/23.
 */
class CountNumberOfTeamsTest {

    private val solution = CountNumberOfTeams()

    @Test
    fun testcase1() {
        val rating = intArrayOf(2, 5, 3, 4, 1)
        assertEquals(3, solution.numTeams(rating))
    }

    @Test
    fun testcase2() {
        val rating = intArrayOf(2, 1, 3)
        assertEquals(0, solution.numTeams(rating))
    }

    @Test
    fun testcase3() {
        val rating = intArrayOf(1, 2, 3, 4)
        assertEquals(4, solution.numTeams(rating))
    }

    @Test
    fun test() {
//        ListFunctor.run {
//            // Cons(head=a1, tail=fun.sure.leetcode.medium.Nil@4c98385c)
//            print(Cons(1, Nil).map { i: Int ->  "a$i"})
//        }
        runBlocking {
            val one = async { searchOne() }
            val two = async { searchTwo() }
            println("Items are ${one.await()} and ${two.await()}")
        }
    }

    suspend fun searchOne(): String {
        delay(1000L)
        println("one")
        return "one"
    }

    suspend fun searchTwo(): String {
        delay(3000L)
        println("two")
        delay(1000L)
        return "two"
    }
}

interface Kind<out F, out A>

interface Functor<F> {
    fun <A, B> Kind<F, A>.map(f: (A) -> B): Kind<F, B>
}

sealed class MyList<out A> : Kind<MyList.K, A> {
    object K
}
object Nil: MyList<Nothing>()
data class Cons<A>(val head: A, val tail: MyList<A>) : MyList<A>()

inline fun <A> Kind<MyList.K, A>.unwrap(): MyList<A> = this as MyList<A>

object ListFunctor: Functor<MyList.K> {
    override fun <A, B> Kind<MyList.K, A>.map(f: (A) -> B): Kind<MyList.K, B> {
        return when (this) {
            is Cons -> {
                val t = this.tail.map(f).unwrap()
                Cons<B>(f(this.head), t)
            }
            else -> Nil
        }
    }
}
