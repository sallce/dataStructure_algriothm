public class UnionFind {
    public int[] size;
    public int[] Arr;
    void initialize(int[] Arr, int N) {
        size = new int[N];
        this.Arr = Arr;
        for (int i = 0; i < N; i++) {
            Arr[i] = i;
            size[i] = 1;
        }
    }

    public int root(int a) {
        int i = Arr[a];
        while(i != Arr[i]) {
            i = Arr[i];
        }
        return i;
    }

    public boolean find(int A, int B) {
        if (root(A) == root(B)) {
            return true;
        } else {
            return false;
        }
    }

    public void weightedUnion (int A, int B) {
        int rootA = root(A);
        int rootB = root(B);

        if (size[rootA] < size[rootB]) {
            Arr[rootA] = Arr[rootB];
            size[rootB] += size[rootA];
        } else {
            Arr[ rootB ] = Arr[rootA];
            size[rootA] += size[rootB];
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.initialize(new int[]{0,1,2,3,4,5}, 5);
        uf.weightedUnion(1,2);
        System.out.println(uf.find(1,2));
        System.out.println(uf.find(1,4));
    }
}
