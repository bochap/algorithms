/**
 * Created by darren on 9/17/14.
 */
public class TwoSumFast {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(a[i] + a[j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = TwoSumFast.count(a);
        double time = timer.elapsedTime();

        StdOut.println(cnt + " triples " + time);
    }
}
