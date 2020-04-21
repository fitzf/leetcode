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
         *   b. 包含：左边索引右移 l++ 如果移动后的左边索引到末尾的长度不大于已存在的最大长度的话 跳出循环
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
                while (r < len) {
                    if (set.contains(s[r])) {
                        set.remove(s[l++])
                        if (len - l <= max) {
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

        /**
         * 优化的滑动窗口
         * 0. 初始化窗口左边和右边的索引为 0 l = 0, r = 0
         * 1. 窗口右边索引递增循环 r++; r < s.length
         * 2. 如果当前右边索引下的字符已经存在，则判断 当前左边索引 > (该字符上次索引 + 1) l > (map[s[\r]] + 1)
         *   a. 是：则说明 (该字符上次索引 + 1) 至 当前左边索引中有其它重复字符，所以忽略，不改变左边索引 l
         *   b. 否：将左边索引移动到 (该字符上次索引 + 1) 的位置 l = (map[s[\r]] + 1)
         * 4. 更新最长子串长度 max = max(已存储的最大长度, 当前窗口长度)
         * 5. 将当前右边索引和字符存入 HashMap<字符，索引>. e.g. {"a": 0, "b": 1}
         * 6. 转到 1 步
         */
        fun optimizedSlidingWindow(s: String): Int = when {
            s.isEmpty() -> 0
            s.length == 1 -> 1
            else -> {
                var max = 0
                val len = s.length
                var l = 0
                var c: Char
                val map: HashMap<Char, Int> = hashMapOf()
                for (r in 0 until len) {
                    c = s[r]
                    map[c]?.let {
                        // 防止左边索引回跳
                        l = l.coerceAtLeast(it + 1)
                    }
                    max = max.coerceAtLeast(r - l + 1)
                    map[c] = r
                }
                max
            }
        }
    }
}