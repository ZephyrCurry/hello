/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package union_find;

import edu.princeton.cs.algs4.StdIn;

public class Bitonic_Array {
    public static void main(String[] args) {
        int[] num = { 1, 5, 7, 12, 34, 67, 43, 38, 25, 14, 3, 2 };
        int x = StdIn.readInt();
        int pos = bitonic_array(x, num);
    }

    public static int binary_search(int pos, int[] num) {

        return -1;
    }

    public static int bitonic_array(int x, int[] num) {
        int l = 0;
        int r = num.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (num[mid] < num[mid - 1]) r = mid - 1;
            else if (num[mid] < num[mid + 1]) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}


// public class Bitonic_Array {
//     public static void main(String[] args) {
//         int[] num = { 1, 5, 7, 12, 34, 67, 43, 38, 25, 14, 3, 2 };
//         int x = StdIn.readInt();
//         int pos = bitonic_array(x, num);
//         int ans1 = binary_search1(x, pos, num);
//         if (ans1 > 0) System.out.println(ans1);
//         else {
//             int ans2 = binary_search2(x, pos, num);
//             if (ans2 > 0) System.out.println(ans2);
//             else System.out.println("can't find it");
//         }
//     }
//
//     private static int binary_search1(int x, int r, int[] num) {
//         int l = 0;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             if (num[mid] > x) r = mid - 1;
//             else if (num[mid] < x) l = mid + 1;
//             else return mid;
//         }
//         return -1;
//     }
//
//     private static int binary_search2(int x, int l, int[] num) {
//         int r = num.length - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             if (num[mid] < x) r = mid - 1;
//             else if (num[mid] > x) l = mid + 1;
//             else return mid;
//         }
//         return -1;
//     }
//
//     public static int bitonic_array(int x, int[] num) {
//         int l = 0;
//         int r = num.length - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             if (num[mid] < num[mid - 1]) r = mid - 1;
//             else if (num[mid] < num[mid + 1]) l = mid + 1;
//             else return mid;
//         }
//         return -1;
//     }
// }
