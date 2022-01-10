package Programming.Trees.MHTs;

import java.util.*;

public class findMinHeightTree {

    public static List<Integer> fmh(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            result.add(0);
            return result;
        }else if (n == 0 || edges == null || edges.length == 0 || edges.length != n - 1) {
            return result;
        }

        boolean[] nodes = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
            nodes[i] = true;
        }
        for (int i = 0; i < edges.length;  i++) {
            if (!map.get(edges[i][0]).contains(edges[i][1])) {
                map.get(edges[i][0]).add(edges[i][1]);
            }
            if (!map.get(edges[i][1]).contains(edges[i][0])) {
                map.get(edges[i][1]).add(edges[i][0]);
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        while (n > 2) {
            for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == 1) {
                    queue.offer(entry.getKey());
                }
            }
            while (!queue.isEmpty()) {
                n--;
                Integer key = queue.poll();
                nodes[key] = false;
                int from = map.get(key).get(0);
                map.get(from).remove(key);
                map.get(key).remove(0);
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i]) {
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args){
        int nodes = 4;
        int[][] edges = new int[][]{{1,0},{1,2},{1,2}};
        findMinHeightTree minHeightTree = new findMinHeightTree();


    }
}
