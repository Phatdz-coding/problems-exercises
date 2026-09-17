class Solution:
    __firstOperator = True

    def isDigit(self, c: chr) -> bool:
        if c >= "0" and c <= "9":
            self.__firstOperator = False
            return True
        elif (c == "-" or c == "+") and self.__firstOperator:
            self.__firstOperator = False
            return True
        return False

    def myAtoi(self, s: str) -> int:
        result = ""

        for c in s:
            if c == " ":
                continue
            elif self.isDigit(c):
                result = result + str(c)
            else:
                break

        if len(result) == 0 or (len(result) == 1 and not self.isDigit(result[0])):
            return 0

        intresult = int(result)
        
        if intresult < (-2**31): return (-2**31)
        elif intresult > (2**31 - 1): return (2**31 - 1)
        return intresult


s = Solution()
print(s.myAtoi("+1"))
