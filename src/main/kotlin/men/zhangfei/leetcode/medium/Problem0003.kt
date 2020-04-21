package men.zhangfei.leetcode.medium

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
class Problem0003 {

    companion object {

        /**
         * 滑动窗口算法
         * 1. 使用 HashSet 作为滑动窗口，存储字符
         * 2. 设置窗口的左边和右边索引为 0 val l = 0, val r = 0
         * 3. 循环判断窗口中是否包含字符串【s】右边索引下的字符，直到窗口滑动到字符串的末尾
         *   a. 不包含：右边索引右移 r++ 并更新窗口的最大长度 max = max(已存储的最大长度, 当前窗口长度)
         *   b. 包含：左边索引右移 l++
         */
        fun slidingWindow(s: String): Int = when {
            s.isEmpty() -> 0
            s.length == 1 -> 1
            else -> {
                var max = 0
                val len = s.length
                var l = 0
                var r = 0
                val set: MutableSet<Char> = mutableSetOf()
                while (l < len && r < len) {
                    if (set.contains(s[r])) {
                        set.remove(s[l++])
                        if (len - l < max) {
                            break
                        }
                    } else {
                        set.add(s[r++])
                        max = max.coerceAtLeast(r - l)
                    }
                }
                max
            }
        }

        fun optimizedSlidingWindow(s: String): Int {
            var max = 0
            if (s.isNotEmpty()) {
                val arr = s.toCharArray()
                var l = 0
                val map: HashMap<Char, Int> = hashMapOf()
                for ((i, c) in arr.withIndex()) {
                    map[c]?.let {
                        l = it.coerceAtLeast(l)
                    }
                    max = max.coerceAtLeast(i - l + 1)
                    map[c] = i + 1
                }
            }
            return max
        }
    }
}