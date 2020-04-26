package men.zhangfei.leetcode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Problem0139Test {

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun dpTest(expected: Boolean, s: String, wordDict: List<String>) {
        assertEquals(expected, Problem0139.dp(s, wordDict))
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun bfsTest(expected: Boolean, s: String, wordDict: List<String>) {
        assertEquals(expected, Problem0139.bfs(s, wordDict))
    }

    companion object {
        @JvmStatic
        fun parameterProvider(): Stream<Arguments> = Stream.of(
            Arguments.arguments(true, "leetcode", listOf("leet", "code")),
            Arguments.arguments(true, "codeleet", listOf("leet", "code")),
            Arguments.arguments(true, "applepenapple", listOf("apple", "pen")),
            Arguments.arguments(false, "catsandog", listOf("cats", "dog", "sand", "and", "cat")),
            Arguments.arguments(false, "a", emptyList<String>()),
            Arguments.arguments(true, "aaaaaaa", listOf("aaaa", "aaa")),
            Arguments.arguments(true, "bbbbbbbbbbbb", listOf("bbbbbbbbbbbb", "a", "c"))
        )
    }
}