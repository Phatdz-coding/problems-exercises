from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        result: List[int] = []

        if root.left is not None:
            result.extend(self.inorderTraversal(root.left))

        result.append(root.val)

        if root.right is not None:
            result.extend(self.inorderTraversal(root.right))

        return result


sampleTree = TreeNode(1, None, TreeNode(2, TreeNode(3), None))
# sampleTree = TreeNode(2)

s = Solution()


print(s.inorderTraversal(sampleTree))
