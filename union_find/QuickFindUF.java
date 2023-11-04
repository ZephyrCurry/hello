/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // public void union(int p, int q) {
    //     for (int i = 0; i < id.length; i++) {
    //         if (id[i] == id[q]) {                   //  wrong code!!!
    //             id[i] = id[p];
    //         }
    //     }
    // }

    public void union(int p, int q) {
        for (int i = 0; i < id.length; i++) {
            int qid = id[q];
            if (id[i] == qid) {
                id[i] = id[p];
            }
        }
    }
}
