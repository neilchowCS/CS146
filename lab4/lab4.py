from collections import deque


class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right

    def invertTree(self, root):
        if root == None:
            return None
        left = root.left
        right = root.right
        #if root.left != None:
        root.left = self.invertTree(right)
        #if root.right != None:
        root.right = self.invertTree(left)
        return root

#note tree in array is not in order, tree1 is root
tree2 = []
tree2.append(TreeNode(3))
tree2.append(TreeNode(4))
tree2.append(TreeNode(5))
tree2.append(TreeNode(6))
tree2.insert(0, TreeNode(8, tree2[2], tree2[3]))
tree2.insert(0, TreeNode(2, tree2[1], tree2[2]))
tree2.insert(0, TreeNode(1, tree2[0], tree2[1]))

def breadth_first(root):
    if not root:
        return

    queue = deque()
    queue.append(root)
    s = ""
    while queue:
        node = queue.popleft()
        s += str(node.val)

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    return s

print(breadth_first(tree2[0]))
tree2[0].invertTree(tree2[0])
print(breadth_first(tree2[0]))
