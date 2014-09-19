/**
 * Created by dseet on 9/19/2014.
 */
public class QuickFindUF {
    public int[] id;
    public  int count;
    public QuickFindUF(int N) {
        id = new int[N];
        count = N;
        // Init array to connect to itself
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId) return;

        for(int i = 0; i < id.length; i++) {
            if(id[i] == pId) id[i] = qId;
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
    }
}
