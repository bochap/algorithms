/**
 * Created by dseet on 9/19/2014.
 */
public class QuickUnionUF {
    public int[] id;
    public  int count;
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        // Init array to connect to itself
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while(p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
    }
}
