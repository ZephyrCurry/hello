/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

public class QuickUnion_Improvement {
    private int[] id;

    private int[] weight;

    public QuickUnion_Improvement(int N) {
        id = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            weight[i] = i;
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
        int rootp = root(p);      //!!!!!!!!!忘记考虑q和p在同一棵树上的情况了
        int rootq = root(q);      // 可能上节课有但是我没好好看清楚   好吧上节课的代码不需要判断
        // id[root(权重大的)]=root(权重小的)
        if (rootp == rootq) return;// 这段是看到老师的视频之后补的  不补会后大bug qwq
        if (weight[rootq] > weight[rootp]) {
            int temp1 = q;
            q = p;
            p = temp1;
            int temp2 = rootq;          // 这里这段代码好丑。。。
            rootq = rootp;
            rootp = temp2;
        }
        id[rootq] = rootp;
        // 修改weight的值
        // weight的值由树的大小决定
        weight[rootp] += weight[rootq];
    }
}
