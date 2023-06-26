package dhruvi.patel.samplejunit.practice

import dhruvi.patel.cashstockapp.practice.FilterCountOfInput
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class FilterCountOfInputTest {

    private lateinit var  filterCountOfInput : FilterCountOfInput

    @Before
    fun setUp(){
        filterCountOfInput  = FilterCountOfInput()
    }

    @After
    fun tearDown(){
        println("After Every Test Case")
    }


    @Test
    fun getFilteredAnswer() {
        val result = filterCountOfInput.getFilteredAnswer("MM")
        assertEquals("2M",result)
    }

    @Test
    fun getFirst3CharTest(){
        val result = filterCountOfInput.getFirst3Char("HelloHowAreYou")

        assertEquals("Hel",result)
    }

}