package lab6;

import java.util.*;

public class lab6 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adjList.get(prereq[0]).add(prereq[1]);
        }

        System.out.println(adjList);

        return kahns(adjList);
    }

    public static boolean kahns(List<List<Integer>> adjList){
        /*indegrees = [0] * len(li)
    for i in li:
        for j in i:
            indegrees[j] += 1

    queue = deque()

    for i in range(len(li)):
        if indegrees[i] == 0:
            queue.append(i)

    output = []

    while len(queue) > 0:
        degree0 = queue.popleft()
        output.append(degree0)
        for adj in li[degree0]:
            indegrees[adj] -= 1
            if indegrees[adj] == 0:
                queue.append(adj)

    if len(output) != len(li):
        return False

    return True*/
        int[] indegrees = new int[adjList.size()];

        for (int i = 0; i < adjList.size(); i++){
            for (int j = 0; j < adjList.get(i).size(); j++){
                indegrees[adjList.get(i).get(j)] += 1;
            }
        }

        /*for i in li:
        for j in i:
            indegrees[j] += 1*/

        System.out.println(Arrays.toString(indegrees));

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> output = new ArrayList<>();
        while (!queue.isEmpty()) {
            int degree0 = queue.poll();
            output.add(degree0);
            for (int adj : adjList.get(degree0)) {
                indegrees[adj] -= 1;
                if (indegrees[adj] == 0)
                    queue.add(adj);
            }
        }

        System.out.println(output);

        if (output.size() != adjList.size()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{0,1}}));
        System.out.println(canFinish(2, new int[][]{{0,1},{1,0}}));
    }
}
