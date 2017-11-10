package com.dataStructure_algriothm.unionfind;

import java.awt.*;

// Implement rank for union and path compression for find
public class DisjointUnionSets {
    int[] rank, parent;
    int n;

    // Constructor
    public DisjointUnionSets(int n){
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    // Create n sets with single item in each
    void makeSet(){
        for(int i = 0; i < n; i++){
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }

    // Return representative of x's set
    int find(int x){
        // Finds the representative of the set
        // that x is an element of
        if(parent[x] != x){
            // if x is not the parent of itself
            // Then x is not the representative of
            // his set
            parent[x] = find(parent[x]);

            // so we recursively call find on its parent
            // and move i's node directly under the
            // representative of this set
        }

        return parent[x];
    }

    // Unites the set that includes x and the set
    // that includes y
    void union(int x, int y){
        // Find representatives of two sets
        int xRoot = find(x);
        int yRoot = find(y);

        // Elements are in the same set, no need
        // to unite anything
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot]){
            // Then move x under y so that depth
            // of tree remains less
            parent[xRoot] = yRoot;
        }else if (rank[yRoot] < rank[xRoot]){
            parent[yRoot] = xRoot;
        }else{
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}

class Main{
    public static void main(String[] args){
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointUnionSets disjointUnionSets = new DisjointUnionSets(n);

        // 0 is friend of 2
        disjointUnionSets.union(0, 2);

        // 4 is a friend of 2
        disjointUnionSets.union(4, 2);

        // 3 is a friend of 1
        disjointUnionSets.union(3, 1);

        // Check if 4 is a friend of 0
        if(disjointUnionSets.find(4) == disjointUnionSets.find(0)){
            System.out.println("Yes, 4 is a friend of 0.");
        }else{
            System.out.println("No,  4 is not a friend of 0.");
        }

        // Check if 1 is a friend of 0
        if(disjointUnionSets.find(1) == disjointUnionSets.find(0)){
            System.out.println("Yes, 1 is a friend of 0.");
        }else{
            System.out.println("No, 1 is not a friend of 0.");
        }
    }
}