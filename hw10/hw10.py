from collections import deque
from typing import Optional, List


class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right

class HW10:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return None

        output = []
        queue = deque()
        queue.append(root)

        while queue:
            length = len(queue)
            temp = []

            for i in range(length):
                node = queue.popleft()
                temp.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            output.append(temp)

        return output

tree1 = []
tree1.append(TreeNode(1))
tree1.append(TreeNode(5))
tree1.append(TreeNode(9))
tree1.insert(0,TreeNode(8,tree1[1],tree1[2]))
tree1.insert(0, TreeNode(3,tree1[1]))
tree1.insert(0, TreeNode(4,tree1[0],tree1[1]))

hw10 = HW10()
print(hw10.levelOrder(tree1[0]))
print(hw10.levelOrder(None))