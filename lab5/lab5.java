package lab5;

import java.util.LinkedList;
import java.util.Queue;

public class lab5 {
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.val >= root.val)
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }


    public static void main(String[] args){
        TreeNode[] tree1 = new TreeNode[6];
        TreeNode[] tree2 = new TreeNode[7];

        tree1[3] = new TreeNode(1);
        tree1[4] = new TreeNode(5);
        tree1[5] = new TreeNode(9);
        tree1[2] = new TreeNode(8, tree1[4], tree1[5]);
        tree1[1] = new TreeNode(3, tree1[3],null);
        tree1[0] = new TreeNode(4, tree1[1],tree1[2]);

        tree2[3] = new TreeNode(3);
        tree2[4] = new TreeNode(4);
        tree2[5] = new TreeNode(5);
        tree2[6] = new TreeNode(6);
        tree2[2] = new TreeNode(8, tree2[5], tree2[6]);
        tree2[1] = new TreeNode(2, tree2[3],tree2[4]);
        tree2[0] = new TreeNode(1, tree2[1],tree2[2]);

        System.out.println(isValidBST(tree1[0]));
        System.out.println(isValidBST(tree2[0]));
    }

}
