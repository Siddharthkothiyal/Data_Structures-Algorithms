package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class ipair{
    long first;
    long second;

    ipair(long _first , long _second){
        this.first = _first;
        this.second = _second;
    }
}

public class waysToArrive {
    public static int countPaths(int n, int[][] roads) {

       ArrayList<List<ipair>> adj = new ArrayList<>();
        for(int i=0 ; i< n ; i++){
            adj.add(new ArrayList<>());
        }
//adjacency list
int m = roads.length;
        for(int i=0 ; i<m ; i++){
            adj.get(roads[i][0]).add(new ipair(roads[i][1] , roads[i][2]));
            adj.get(roads[i][1]).add(new ipair(roads[i][0] , roads[i][2]));
        }

        long ways [] = new long [n];
        long dist [] = new long [n];

        for(int i=0; i<n ; i++){
            ways[i]=0;
            dist[i]= Long.MAX_VALUE;
        }

PriorityQueue<ipair> pq = new PriorityQueue<ipair>((x, y) -> Long.compare(x.first ,y.first));
        //create a priority queue
ways[0]=1;
dist[0]=0;
pq.add(new ipair(0, 0));
long mod = (int)(1e9 + 7);
while(pq.size()!= 0){
    ipair it = pq.peek();
    long dis = it.first;
    long node = it.second;
    pq.remove();

    for(ipair iter : adj.get((int)node)){
        long adjNode = iter.first;
        long edw = iter.second;

        if(dis + edw < dist[(int) adjNode]){
            dist[(int) adjNode]= dis + edw;
            pq.add(new ipair(dis + edw , adjNode));
            ways[(int) adjNode] = ways[(int)node];

        }else if(dist[(int)adjNode] == dis + edw){
            ways[(int)adjNode]= (ways[(int)adjNode] + ways[(int)node]) % mod;
        }

    }

}

return (int) (ways[n-1] % mod );
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };

        System.out.println(countPaths(n, roads));
    }
}
