package ec2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ec2 {
    public int[][] listToMatrix(List<LinkedList<Integer>> list) {
        int[][] matrix = new int[list.size()][list.size()];

        for (int i = 0; i < list.size(); i++) {
            for (Integer j : list.get(i)) {
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public List<LinkedList<Integer>> matrixToList(int[][] matrix) {
        List<LinkedList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            LinkedList<Integer> out = new LinkedList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    out.add(j);
                }
            }
            list.add(out);
        }
        return list;
    }

    public void reverseGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}