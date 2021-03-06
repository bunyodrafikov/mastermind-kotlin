package bunyodrafikov.mastermind

import jesusgsdev.mastermind.Evaluation
import jesusgsdev.mastermind.evaluateGuess
import org.junit.Assert
import org.junit.Test

class MastermindTests {

    private fun testEvaluation(secret: String, guess: String, positions: Int, letters: Int) {
        val expected = Evaluation(positions, letters)
        val evaluation = evaluateGuess(secret, guess)
        Assert.assertEquals("Wrong evaluation for secret=$secret, guess=$guess",
                expected, evaluation)
    }

    // simple
    @Test
    fun testEqual() = testEvaluation("ABCD", "ABCD", 4, 0)

    @Test
    fun testOnlyLetters() = testEvaluation("DCBA", "ABCD", 0, 4)

    @Test
    fun testSwap() = testEvaluation("ABCD", "ABDC", 2, 2)

    @Test
    fun testPositions() = testEvaluation("ABCD", "ABCF", 3, 0)

    @Test
    fun testLetters() = testEvaluation("DAEF", "FECA", 0, 3)


    // repeated letters
    @Test
    fun testSample() = testEvaluation("AABC", "ADFE", 1, 0)

    @Test
    fun testFromExam() = testEvaluation("CFDF", "FCCD", 0, 3)

    @Test
    fun testFromExam2() = testEvaluation("AABC", "ADFA", 1, 1)

    @Test
    fun testFromExam3() = testEvaluation("BBDC", "DFBB", 0, 3)

    @Test
    fun myOwnTest() = testEvaluation("ABCD", "AAAA", 1, 0)


}