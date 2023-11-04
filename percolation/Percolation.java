package percolation;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */



/*

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
Now, implement the Percolation data type
 using the weighted quick union algorithm in WeightedQuickUnionUF.

By convention, the row and column indices are integers between 1 and n,
where (1, 1) is the upper-left site: Throw an IllegalArgumentException if
any argument to open(), isOpen(), or isFull() is outside its prescribed range.
Throw an IllegalArgumentException in the constructor if n ≤ 0.

*/

/*

实现步骤：

1.阅读WeightedQuickUnionUF的实现原理--

2.编写利用WeightedQuickUnionUF实现Percolation类--

3.随机生成open site并判断是否已经渗透并把open site数记录到数组num[n^2]中

4.将num进行处理，得到区间

5.将结果格式化输出

得先弄清楚main函数的工作原理，放在一个类里要如何调用 --- What a stupid question......

*/



/*

public QuickFindUF(int N)

public int count()

public boolean connected(int p, int q)

public void union(int p, int q)


 */



/*

[INFO] Percolation.java:103: Using a loop in this method might be a performance bug. [Performance]
[INFO] Percolation.java:104: Using a loop in this method might be a performance bug. [Performance]

[WARN] Percolation.java:1: We recommend defining at least one private helper method, e.g., to validate the row and column indices or to map from 2D to 1D indices. [Design]
这就是国外的技术资源吗？？连设计问题都能指出来，实在是让人佩服

[WARN] Percolation.java:56: Declaring 1 non-final static variables ('u') suggests poor design in this class. [StaticVariableCount]

[WARN] Percolation.java:83:5: Define constructors after static and instance variables but before methods. [DeclarationOrder]

check for backwash with predetermined sites          //backwash要怎么处理啊啊啊啊啊

 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF u;

    private boolean[] site;

    private int n;

    private int open_numbers;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n<=0 is illegal");
        this.n = n;
        u = new WeightedQuickUnionUF(n * n + 2);
        site = new boolean[n * n];
    }

    private int swich(int row, int col) {
        return n * (row - 1) + col - 1;
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) return;
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("out of range");
        site[swich(row, col)] = true;
        if (row == 1) u.union(0, col);
        if (row == n) u.union(n * n + 1, swich(row, col) + 1);
        if (col > 1 && site[swich(row, col - 1)])
            u.union(swich(row, col) + 1, swich(row, col - 1) + 1);
        if (col < n && site[swich(row, col + 1)])
            u.union(swich(row, col) + 1, swich(row, col + 1) + 1);
        if (row > 1 && site[swich(row - 1, col)])
            u.union(swich(row, col) + 1, swich(row - 1, col) + 1);
        if (row < n && site[swich(row + 1, col)])
            u.union(swich(row, col) + 1, swich(row + 1, col) + 1);
        open_numbers++;
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("out of range");
        return site[swich(row, col)];
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("out of range");
        return u.find(0) == u.find(swich(row, col) + 1);
    }

    public int numberOfOpenSites() {
        return open_numbers;
    }

    public boolean percolates() {
        return u.find(0) == u.find(n * n + 1);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.open(2, 1);
        System.out.println(p.isOpen(1, 2));
        System.out.println(p.isOpen(1, 3));
        for (int row = 1; row <= 10; row++) {
            p.open(row, 3);
        }
        System.out.println(p.percolates());
        System.out.println(p.numberOfOpenSites());
        System.out.println("---------------");
        System.out.println(p.isFull(2, 1));
        p.open(1, 1);
        System.out.println(p.isFull(2, 1));
        System.out.println(p.numberOfOpenSites());
    }
}




/*

                                                   old design before improved

public class Percolation {

    private static WeightedQuickUnionUF u;

    private int[] site;

    private int n;                                                  // why can't use static?

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n<=0 is illegal");
        this.n = n;
        u = new WeightedQuickUnionUF(n * n + 2);
        site = new int[n * n];
    }

    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("out of range");
        site[n * (row - 1) + col - 1] = 1;
        if (row == 1) u.union(0, col - 1);
        if (row == n) u.union(n * n + 1, n * (row - 1) + col - 1);
        if (col > 1 && site[n * (row - 1) + col - 2] == 1)
            u.union(n * (row - 1) + col - 1, n * (row - 1) + col - 2);
        if (col < n && site[n * (row - 1) + col] == 1)
            u.union(n * (row - 1) + col - 1, n * (row - 1) + col);
        if (row > 1 && site[n * (row - 2) + col - 1] == 1)
            u.union(n * (row - 1) + col - 1, n * (row - 2) + col - 1);
        if (row < n && site[n * (row) + col - 1] == 1)
            u.union(n * (row - 1) + col - 1, n * (row) + col - 1);
    }

    public boolean isOpen(int row, int col) {                         // why can't use static???
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("out of range");
        return site[n * (row - 1) + col - 1] == 1;
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException("out of range");
        return site[n * (row - 1) + col - 1] == 0;
    }

    public int numberOfOpenSites() {
        int count = 0;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (site[n * (row - 1) + col - 1] == 1) count++;
            }
        }
        return count;
    }

    public boolean percolates() {
        return u.find(0) == u.find(n * n + 1);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.open(1, 2);
        System.out.println(p.isOpen(1, 2));
        System.out.println(p.isOpen(1, 3));
        for (int row = 1; row <= 10; row++) {
            p.open(row, 1);
        }
        System.out.println(p.percolates());
        System.out.println(p.numberOfOpenSites());
    }
}
*/