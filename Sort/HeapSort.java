/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Sort;

public class HeapSort {

    private static Comparable[] pq;

    public static void sort(Comparable[] a) {

        pq = new Comparable[a.length + 1];
        for (int i = 1; i <= a.length; i++) {
            pq[i] = a[i - 1];
        }

        int N = a.length;
        for (int k = N / 2; k > 0; k--) {
            sink(k, N);
        }

        while (N > 1) {
            exch(1, N--);
            sink(1, N);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = pq[i + 1];
        }
    }

    private static void sink(int k, int N) {
        while (2 * k < N + 1) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    private static boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private static void exch(int i, int j) {
        Comparable temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = { 65, 37, 93, 14, 43, 62, 75 };
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
