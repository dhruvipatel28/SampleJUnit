package dhruvi.patel.cashstockapp.practice

import android.util.Log
import androidx.compose.runtime.remember

/*
* Expected Output:
4W3C2M

Explanation:
‘W’ has the highest count, then ‘C’, then ‘M’.
⚠️⚠️⚠️ Note:
- The input is already parsed and passed to a function.
- You need to "print" the final result (not return it) to pass the test cases.
- If the input is- “MMW”, then the expected output is "2M1W" since there is no ‘C’.
- If any of them have the same count, the output should follow this order - M, W, C.


- Hightst count comes first
CCMWCW - 3C2W1M
WMCWMCMCC - 4C3M2W

- If W/M/C is not present don't include in output
CCCMMM - 3M3C

- If Any of them have same count output should follow order M, W, C
MMWCCMWC  - 3M2W3C
WWMMCCC  -   2M2W3C
CCCMMM - 3M3C
WWCCM - 1M2W2C

*/

class FilterCountOfInput {

    init {
        println("Init method has called after calling the class or say creating clas instance")
        val inputList = arrayListOf<String>(
            "MMCCWMCWMMCC243fq",
            "CCMWCW ",
            "CCC MMM",
            "MMWCCM WC",
            "CCC MMM",
            "WW 7bh CCM",
            "hdfuief2431jknkjf",
            "t7@%$&whgvhmmfytc"
        )
        for(item in inputList){
            getFilteredAnswer(item)
        }
    }

    fun getFirst3Char(input : String) : String{
        return input.take(3)
    }

    fun getFilteredAnswer(input: String) : String{
        val answerString = printResult(filterCount(input = input))
        if(answerString.isEmpty()){
            println("Dhruvi Filter Class Input: $input - Is not Valid Input")
        }else{
            println("Dhruvi Filter Class Input: $input -  Answer is: $answerString")
        }
        return answerString
    }

    private fun filterCount(input: String) : MutableMap<String, Int> {
        var men = 0
        var women = 0
        var child = 0

        for (ch in input) {
            when (ch) {
                'M' -> {
                    men += 1
                }
                'W' -> {
                    women += 1
                }
                'C' -> {
                    child += 1
                }
                else -> { continue }
            }
        }

        val map = mutableMapOf<String, Int>()

        // Create a map to add in order of M, W, C
        if (men > 0) {
            map[men.toString() + "M"] = men
        }
        if (women > 0) {
            map[women.toString() + "W"] = women
        }
        if (child > 0) {
            map[child.toString() + "C"] = child
        }

        // IF any 2 has same value create a string with Key as answer
        return if (men == women || men == child || women == child) {
            map
        } else {  // Of all values are different then sort the list with key int descending
            map.toSortedMap(compareByDescending { it })
        }
    }

    private fun printResult(map: MutableMap<String, Int>)  : String{
        val answerString = StringBuilder()
        for (i in map) {
            answerString.append(i.key)
        }
        return answerString.toString()
    }
}