package lab4;

import java.util.LinkedList;
import java.util.Queue;

public class lab4 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public static String breadth_first(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        String s = "";
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            s += node.val;

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return s;
    }

    public static void main(String[] args){
        TreeNode[] tree1 = new TreeNode[7];
        /*
        tree1.append(TreeNode(1))
        tree1.append(TreeNode(5))
        tree1.append(TreeNode(9))
        tree1.insert(0,TreeNode(8,tree1[1],tree1[2]))
        tree1.insert(0, TreeNode(3,tree1[1]))
        tree1.insert(0, TreeNode(4,tree1[0],tree1[1]))

        print(tree1[0].lowestCommonAncestor(tree1[0],tree1[1],tree1[3]).val)
        print(tree1[0].lowestCommonAncestor(tree1[0],tree1[3],tree1[4]).val)
        */
        tree1[3] = new TreeNode(3);
        tree1[4] = new TreeNode(4);
        tree1[5] = new TreeNode(5);
        tree1[6] = new TreeNode(6);
        tree1[2] = new TreeNode(8, tree1[5], tree1[6]);
        tree1[1] = new TreeNode(2, tree1[3],tree1[4]);
        tree1[0] = new TreeNode(1, tree1[1],tree1[2]);

        System.out.println(breadth_first(tree1[0]));
        invertTree(tree1[0]);
        System.out.println(breadth_first(tree1[0]));
    }

}
