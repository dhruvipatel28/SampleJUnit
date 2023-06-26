package dhruvi.patel.samplejunit.practice

import dhruvi.patel.cashstockapp.practice.FilterCountOfInput
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


@RunWith(value = Parameterized::class)
class ParameterizedTest(private val input : String, private val expectedValue: String) {


    @Test
    fun test(){
        val filterCountOfInput = FilterCountOfInput()
        val result = filterCountOfInput.getFilteredAnswer(input)
        assertEquals(expectedValue, result)
    }


    companion object{

        @JvmStatic
        @Parameters(name = "InoutString: {0} : Result: {1}")
        fun data() : List<Array<Any>>{
            return listOf(
                arrayOf("MMCCWMCWMMCC243fq","5M2W5C"),
                arrayOf("CCMWCW","3C2W1M"),
                arrayOf("CCC MMM","3M3C"),
                arrayOf("MMWCCM WC","3M2W3C"),
                arrayOf("CCC MMM","3M3C"),
                arrayOf("WW 7bh CCM","1M2W2C"),
                arrayOf("hdfuief2431jknkjf",""),
                arrayOf("t7@%$&whgvhmmfytc",""),
                //arrayOf("t7@%34 af35 24 daf#$%","2M3C"), Uncomment to failed testcase
            )
        }
    }


}