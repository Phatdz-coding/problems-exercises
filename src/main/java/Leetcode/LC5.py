class Solution:
    def helper(self, s: str, i: int) -> str:
        left = i - 1
        right = i + 1
        lenstr = len(s)
        current_char = s[i]
        isFound = False
        isEven = True
        left_result = right_result = i
        while True:
            left_char = right_char = ''

            if left >= 0:
                left_char = s[left]
            if right < lenstr:
                right_char = s[right]

            # case for odd palindrome
            if left_char == right_char and left_char != '' and right_char != '':
                left_result, right_result = left, right
                left -= 1
                right += 1
                isFound, isEven = True, False
            # case for even palindrome
            elif right_char == current_char and isEven:
                left_result, right_result = i, right
                right += 1
                isFound = True
            elif not isFound:
                return str(current_char)
            else:
                break

        return s[left_result : right_result + 1]

    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1:
            return s
        max, result = 0, ""
        lenstr = len(s)
        for i in range(0, lenstr):
            r = self.helper(s, i)

            if len(r) > max:
                max = len(r)
                result = r
        return result


s = Solution()

result = s.longestPalindrome("bb")

print(result)
