package interview;

import hw9.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class tree {

    public static int kthSmallest(hw9.TreeNode root, int k) {
        List<Integer> arr = new ArrayList<Integer>();
        inOrder(root, arr);
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr);
        }
        return arr.get(k-1);

    }


    public static void inOrder(hw9.TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

    public static void main(String[] args){
        TreeNode[] tree1 = new TreeNode[6];

        List<Integer> arr = new ArrayList<>();
        tree1[3] = new TreeNode(1);
        tree1[4] = new TreeNode(5);
        tree1[5] = new TreeNode(9);
        tree1[2] = new TreeNode(8, tree1[4], tree1[5]);
        tree1[1] = new TreeNode(3, tree1[3],null);
        tree1[0] = new TreeNode(4, tree1[1],tree1[2]);

        System.out.println(kthSmallest(tree1[0], 1));

    }
}
