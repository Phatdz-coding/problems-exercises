from typing import List
import numpy as np


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        result = 0
        array_len = len(nums)
        for i in range(1, array_len):
            j = 0
            while j + i <= array_len:
                s = int(np.sum(nums[j : j + i]))
                # print(s)
                if s == k:
                    result += 1
                j += 1
            pass
        
        result += 1 if int(np.sum(nums)) == k else 0
        
        return result


s = Solution()

nums = [1,-1,0]
k = 0
r = s.subarraySum(nums, k)
print(r)