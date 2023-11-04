/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

public class QuickUnion_Improvement_v2 {
    private int[] id;

    private int[] weight;

    public QuickUnion_Improvement_v2(int N) {
        id = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            weight[i] = i;
        }
    }

    private int root(int p) {
        if (p != id[p]) {
            id[p] = id[id[p]];// 非常高效的一段代码，可以flatten the tree,要多理解！！！
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }


    // 这段是老师给出的代码，简洁很多，但在复用性上任有点小缺憾
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return;
        if (weight[rootq] < weight[rootp]) {
            id[rootq] = id[rootp];
            weight[p] += weight[q];
        }
        else {
            id[rootp] = id[rootq];
            weight[q] += weight[p];
        }
    }
}
