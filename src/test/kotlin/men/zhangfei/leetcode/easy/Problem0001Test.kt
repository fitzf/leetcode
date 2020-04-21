package men.zhangfei.leetcode.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Problem0001Test {

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun twoSumTest(expected: IntArray, nums: IntArray, target: Int) {
        assertArrayEquals(expected, Problem0001.twoSum(nums, target))
    }

    companion object {
        @JvmStatic
        fun parameterProvider(): Stream<Arguments> = Stream.of(arguments(intArrayOf(0, 1), intArrayOf(2, 7, 11, 15), 9))
    }
}