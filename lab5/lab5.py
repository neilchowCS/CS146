class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
        self.val = val

        self.left = left

        self.right = right

    def isValidBST(self, root):
        if root == None:
            return True
        if root.left != None and root.left.val >= root.val:
            return False
        if root.right != None and root.right.val <= root.val:
            return False

        return self.isValidBST(root.left) and self.isValidBST(root.right)

tree1 = []
tree1.append(TreeNode(1))
tree1.append(TreeNode(5))
tree1.append(TreeNode(9))
tree1.insert(0,TreeNode(8,tree1[1],tree1[2]))
tree1.insert(0, TreeNode(3,tree1[1]))
tree1.insert(0, TreeNode(4,tree1[0],tree1[1]))

print(tree1[0].isValidBST(tree1[0]))

tree2 = []
tree2.append(TreeNode(3))
tree2.append(TreeNode(4))
tree2.append(TreeNode(5))
tree2.append(TreeNode(6))
tree2.insert(0, TreeNode(8, tree2[2], tree2[3]))
tree2.insert(0, TreeNode(2, tree2[1], tree2[2]))
tree2.insert(0, TreeNode(1, tree2[0], tree2[1]))

print(tree2[0].isValidBST(tree2[0]))
