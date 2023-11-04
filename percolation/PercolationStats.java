package percolation;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */



/*
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
Use StdRandom to generate random numbers;
use StdStats to compute the sample mean and sample standard deviation.

Throw an IllegalArgumentException in the constructor if either n ≤ 0 or trials ≤ 0.

*/




/*

[WARN] PercolationStats.java:37:18: The local (or parameter) variable 'num' has the same name as an instance variable. Use a different name. [HiddenField]
[WARN] PercolationStats.java:74:13: The local variable 'T' must start with a lowercase letter and use camelCase. [LocalVariableName]


 */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double mean;

    private double threshold;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("n<=0 or T<=0");
        double[] num = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;
                p.open(row, col);
            }
            num[i] = (double) p.numberOfOpenSites() / (n * n);
        }
        mean = StdStats.mean(num);
        threshold = 1.96 * StdStats.stddev(num) / Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return threshold;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - threshold;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + threshold;
    }

    // test client (see below)
    public static void main(String[] args) {
        // int n = StdIn.readInt();
        // int t = StdIn.readInt();
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println(
                "95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
