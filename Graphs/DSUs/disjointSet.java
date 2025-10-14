package Graphs.DSUs;


import java.util.*;


//constructor to initialize Disjoint sets
public class disjointSet {
    List<Integer> rank;
     List<Integer> parent;
     List<Integer> size;
     public disjointSet(int n) {

         rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();

        // Start from 0 or 1 depending on problem convention.
        for (int i = 0; i <= n; i++) { // using <= n for 1-based indexing
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }


    public int findUParent(int node) {

        if (node==parent.get(node)) {
            return node;
        }
        //ultimate parent 
        int ulp= findUParent(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);

    }

    public void unionByRank(int u, int v) {
        int ulp_u= findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u ==  ulp_v) return ;
        if(rank.get(ulp_u)< rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v)< rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else{
             parent.set(ulp_v, ulp_u);
             int rankU= rank.get(ulp_u);
             rank.set(ulp_u, rankU+1);
        }  
    }

    public void unionBySize(int u, int v) {
         int ulp_u= findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u ==  ulp_v) return ;
        if(size.get(ulp_u)< size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
           size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
             parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }  
    }

    public static void main(String[] args) {
        disjointSet ds = new disjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
    }

