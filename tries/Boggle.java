
//Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
//Find all possible words that can be formed by a sequence of adjacent characters.
//Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

package com.dataStructure_algriothm.tries;

public class Boggle {

    // Alphabet size
    static final int SIZE = 26;

    static final int M = 3;
    static final int N = 3;

    // Trie Node
    static class TrieNode
    {
        TrieNode[] child = new TrieNode[SIZE];

        // isLeaf is true if the node represents
        // end of a word
        boolean leaf;

        //constructor
        public TrieNode() {
            leaf = false;
            for (int i = 0; i < SIZE; i++)
                child[i] = null;
        }

    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks leaf node
    static void insert(TrieNode root, String key)
    {
        int n = key.length();
        TrieNode pChild = root;

        for(int i = 0; i < n; i++)
        {
            int index = key.charAt(i) - 'A';
            if(pChild.child[index] == null)
                pChild.child[index] = new TrieNode();

            pChild = pChild.child[index];
        }

        // make last node as leaf node
        pChild.leaf = true;
    }

    // function to check that current location
    // (i and j) is in matrix range
    static boolean isSafe(int i, int j, boolean visited[][])
    {
        return (i >= 0 && i < M && j >= 0 &&
                j < N && !visited[i][j]);
    }

    // A recursive function to print all words present on boggle
    static void searchWord(TrieNode root, char boggle[][], int i, int j, boolean visited[][], String str)
    {
        // if we found word in trie / dictionary
        if(root.leaf == true)
            System.out.println(str);

        // If both i and j in range and we visited
        // that element of matrix first time
        if(isSafe(i, j, visited))
        {
            // make it visited
            visited[i][j] = true;

            // Traverse all child of current root
            for(int K = 0; K < SIZE; K++)
            {
                if(root.child[K] != null)
                {
                    // current character
                    char ch = (char)(K + 'A');

                    // Recursively search reaming character of word
                    // in trie for all 8 adjacent cells of
                    // boggle[i][j]
                    if (isSafe(i+1,j+1,visited) && boggle[i+1][j+1]
                            == ch)
                        searchWord(root.child[K],boggle,i+1,j+1,
                                visited,str+ch);
                    if (isSafe(i, j+1,visited)  && boggle[i][j+1]
                            == ch)
                        searchWord(root.child[K],boggle,i, j+1,
                                visited,str+ch);
                    if (isSafe(i-1,j+1,visited) && boggle[i-1][j+1]
                            == ch)
                        searchWord(root.child[K],boggle,i-1, j+1,
                                visited,str+ch);
                    if (isSafe(i+1,j, visited)  && boggle[i+1][j]
                            == ch)
                        searchWord(root.child[K],boggle,i+1, j,
                                visited,str+ch);
                    if (isSafe(i+1,j-1,visited) && boggle[i+1][j-1]
                            == ch)
                        searchWord(root.child[K],boggle,i+1, j-1,
                                visited,str+ch);
                    if (isSafe(i, j-1,visited)&& boggle[i][j-1]
                            == ch)
                        searchWord(root.child[K],boggle,i,j-1,
                                visited,str+ch);
                    if (isSafe(i-1,j-1,visited) && boggle[i-1][j-1]
                            == ch)
                        searchWord(root.child[K],boggle,i-1, j-1,
                                visited,str+ch);
                    if (isSafe(i-1, j,visited) && boggle[i-1][j]
                            == ch)
                        searchWord(root.child[K],boggle,i-1, j,
                                visited,str+ch);
                }
            }

            // make current element unvisited
            visited[i][j] = false;
        }
    }

    // Print all words present in dictionary.
    static void findWords(char boggle[][], TrieNode root)
    {
        //Mark all characters as not visited
        boolean[][] visited = new boolean[M][N];
        TrieNode pChild = root;

        String str = "";

        // traverse all matrix elements
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                // we start searching for word in dictionary
                // if we found a character which is child
                // of Trie root
                if (pChild.child[(boggle[i][j]) - 'A'] != null)
                {
                    str = str+boggle[i][j];
                    searchWord(pChild.child[(boggle[i][j]) - 'A'],
                            boggle, i, j, visited, str);
                    str = "";
                }
            }
        }
    }


    // Driver program to test above function
    public static void main(String args[])
    {
        // Let the given dictionary be following
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};

        // root Node of trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie
        for(String word : dictionary)
        {
            insert(root, word);
        }

        char boggle[][] = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}
        };

        findWords(boggle, root);
    }

}
