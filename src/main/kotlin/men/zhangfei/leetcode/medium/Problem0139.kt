package men.zhangfei.leetcode.medium

import java.util.LinkedList
import java.util.Queue


/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 */
class Problem0139 {

    companion object {

        /**
         * 动态规划
         * 字符串 s 可以被拆分成子字符串 s1 和 s2
         * 如果这些子字符串都可以独立地被拆分成符合要求的子字符串，那么整个字符串 s 也可以满足
         * e.g. s = "catsanddog", wordDict = ["cats", "dog", "sand", "and", "cat"]
         * s1 = "catsand", s2 = "dog"
         * s1-1 = "cats", s1-2 = "and"
         * s1-1, s1-2 满足, 所以 s1 也满足， s1, s2 都满足，所以 s 也满足
         */
        fun dp(s: String, wordDict: List<String>): Boolean {
            val len = s.length
            val dp = BooleanArray(len + 1)
            // 空字符串总是字典的一部分, 剩余为 false
            dp[0] = true
            for (r in 1..len) {
                // 通过下标 l 将字符串 s[0, r) 拆分成 s1, s2
                for (l in 0 until r) {
                    // 检查 s1 s[0, j) 是否满足条件 检查 s2 s[j, r) 是否满足条件，如果满足，说明 s[0, r) 满足 dp[r] = true
                    if (dp[l] && wordDict.contains(s.substring(l, r))) {
                        dp[r] = true
                        break
                    }
                }
            }
            return dp[len]
        }

        /**
         * 宽度优先搜索
         */
        fun bfs(s: String, wordDict: List<String>): Boolean {
            val len = s.length
            val queue: Queue<Int> = LinkedList()
            val visited = IntArray(len)
            queue.add(0)
            var start: Int
            while (!queue.isEmpty()) {
                start = queue.remove()
                if (0 == visited[start]) {
                    for (end in (start + 1)..len) {
                        if (wordDict.contains(s.substring(start, end))) {
                            queue.add(end)
                            if (end == len) {
                                return true
                            }
                        }
                    }
                    visited[start] = 1
                }
            }
            return false
        }
    }
}