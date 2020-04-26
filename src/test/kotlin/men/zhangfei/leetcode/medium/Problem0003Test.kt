package men.zhangfei.leetcode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Problem0003Test {

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun slidingWindowTest(expected: Int, s: String) {
        assertEquals(expected, Problem0003.slidingWindow(s))
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun optimizedSlidingWindowTest(expected: Int, s: String) {
        assertEquals(expected, Problem0003.optimizedSlidingWindow(s))
    }

    companion object {
        @JvmStatic
        fun parameterProvider(): Stream<Arguments> = Stream.of(
            arguments(3, "abcabcbb"),
            arguments(1, "bbbbb"),
            arguments(3, "pwwkew"),
            arguments(2, "abba"),
            arguments(3, "cbabcb")
        )
    }
}