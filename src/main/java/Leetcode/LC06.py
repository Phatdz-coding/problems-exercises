class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # NO 2D ARRAY WAS USED TO SOLVED THIS --> Space complexity: O(n)
        # Time complexity: O(n)
        length = 2 * numRows - 2
        a, b = length, 0
        lenstr = len(s)
        
        if lenstr <= numRows or length == 0:
            return s

        for i in range(0, numRows):
            parts = []
            for i in range(0, numRows):
                parts.append(s[i])

                b = 2*i
                a = length - b

                k = i
                while k < lenstr:
                    k += a
                    if k < lenstr and a != 0:
                        parts.append(s[k])
                    k += b
                    if k < lenstr and b != 0:
                        parts.append(s[k])
            return ''.join(parts)
s = Solution()

result = s.convert("AB", 1)

print(result)
