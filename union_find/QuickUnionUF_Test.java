/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

public class QuickUnionUF_Test {
    public static void main(String[] args) {
        QuickUnionUF qu = new QuickUnionUF(8);
        qu.union(0, 1);
        qu.union(0, 2);
        qu.union(1, 4);
        qu.union(3, 6);
        qu.union(5, 7);
        System.out.println(qu.connected(1, 2));// t
        System.out.println(qu.connected(1, 3));// f
        System.out.println(qu.connected(3, 6));// t
        System.out.println(qu.connected(5, 7));// t
    }
}
