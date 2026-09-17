from typing import List


class Solution:
    def mergeArrays(self, a: List[int], b: List[int]) -> List[int]:
        final_list = []
        a_i = b_i = 0
        a_len, b_len = len(a), len(b)
        while a_i < a_len or b_i < b_len:
            m = n = 10000000000000000000
            if a_i < a_len:
                m = a[a_i]
            if b_i < b_len:
                n = b[b_i]

            if m <= n:
                final_list.append(m)
                a_i += 1
            else:
                final_list.append(n)
                b_i += 1

        return final_list

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        new_array = self.mergeArrays(nums1, nums2)
        new_len = len(new_array)
        result = 0
        if new_len % 2 == 0:
            mid = int(new_len / 2)
            return (new_array[mid - 1] + new_array[mid]) / 2
        return new_array[int(new_len/2)]


a = [1, 2]
b = [3,4]

s = Solution()

print(s.findMedianSortedArrays(a, b))
# print(a.)
