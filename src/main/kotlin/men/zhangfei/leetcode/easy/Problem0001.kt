package men.zhangfei.leetcode.easy

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
class Problem0001 {

    companion object {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val map: HashMap<Int, Int> = hashMapOf()
            var remainder: Int
            for ((i, num) in nums.withIndex()) {
                remainder = target - num
                if (map.containsKey(remainder)) {
                    return intArrayOf(map[remainder]!!, i)
                }
                map[num] = i
            }
            throw IllegalArgumentException("No two sum solution")
        }
    }
}