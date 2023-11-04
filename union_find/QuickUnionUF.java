/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

// public class QuickUnionUF {
//     int[] id;
//
//     public QuickUnionUF(int N) {
//         id = new int[N];
//         for (int i = 0; i < N; i++) {
//             id[i] = i;
//         }
//     }
//
//     public boolean connected(int p, int q) {
//         if (p != id[p]) {
//             p = id[p];
//         }
//         if (q != id[q]) {
//             q = id[q];
//         }
//         return p == q;
//     }
//
//     public void union(int p, int q) {
//         if (p != id[p]) {
//             p = id[p];
//         }
//         id[q] = p;
//         // System.out.println("-----------------");
//         // for (int i = 0; i < 8; i++) {
//         //     System.out.print("  " + id[i]);
//         //     System.out.println();
//         // }
//     }
//
// }


// 要提高复用性！！！！！
// 于是可以把寻找根节点的程序抽象出来，用root()表示


public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int p) {
        if (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(q)] = root(p);
        // System.out.println("-----------------");
        // for (int i = 0; i < 8; i++) {
        //     System.out.print("  " + id[i]);
        //     System.out.println();
        // }
    }

}
