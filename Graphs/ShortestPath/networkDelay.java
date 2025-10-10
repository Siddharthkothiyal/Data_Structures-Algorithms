package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class networkDelay {
    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new Pair(time, v));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] totalTime = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            totalTime[i] = (int) 1e9;
        }
        totalTime[k] = 0;
        pq.add(new Pair(0, k));

        while (pq.size() != 0) {
            int tm = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            if (tm > totalTime[node])
                continue;

            for (Pair iter : adj.get(node)) {
                int edw = iter.first;
                int adjNode = iter.second;

                if (edw + tm < totalTime[adjNode]) {
                    totalTime[adjNode] = edw + tm;
                    pq.add(new Pair(totalTime[adjNode], adjNode));
                }
            }

        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (totalTime[i] == (int) 1e9) {
                return -1;
            } else {
                maxTime = Math.max(maxTime, totalTime[i]);
            }

        }

        return maxTime;
    }

    public static void main(String[] args) {
        int[][] times = { { 1, 2, 1 }};
        int n = 2;
        int k = 1;

        System.out.println(networkDelayTime(times, n, k));
    }
}
