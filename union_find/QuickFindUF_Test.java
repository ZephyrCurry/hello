/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

public class QuickFindUF_Test {
    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(5);
        qf.union(0, 1);
        qf.union(2, 3);
        System.out.println(qf.connected(0, 4));
        System.out.println(qf.connected(0, 3));
        System.out.println(qf.connected(2, 3));
        qf.union(0, 2);
        System.out.println(qf.connected(0, 4));
        System.out.println(qf.connected(0, 3));
        System.out.println(qf.connected(2, 3));
    }
}
