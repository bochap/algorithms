/**
 * Created by dseet on 9/19/2014.
 */
public class CompressedWeightedQuickUnionUF {
    public int[] id;
    public int[] size;
    public CompressedWeightedQuickUnionUF(int N) {
        id = new int[N];
        // Init array to connect to itself
        for (int i = 0; i < N; i++) {
            id[i] = id[id[i]];
            id[i] = i;
        }
    }

    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        if(size[i] < size[j]) { id[i] = j; size[j] += size[i]; }
        else { id[j] = i; size[i] += size[j]; }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        CompressedWeightedQuickUnionUF uf = new CompressedWeightedQuickUnionUF(N);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
    }
}
