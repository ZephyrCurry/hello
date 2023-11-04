/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Sort;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k < N + 1) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(9);
        pq.insert(1);
        pq.insert(5);
        pq.insert(6);
        pq.insert(3);
        pq.insert(2);
        pq.insert(9);
        pq.insert(8);
        pq.insert(4);
        pq.insert(7);
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
        System.out.println((int) pq.delMax());
    }
}
