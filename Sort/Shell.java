/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Sort;

public class Shell {

    public static void Shell_Sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    show(a);
                }
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        // String s = scanner.nextLine();
        // Scanner sc = new Scanner(s);
        // ArrayList<Integer> arr = new ArrayList<>();
        // while (sc.hasNextInt()) {
        //     arr.add(sc.nextInt());
        // }
        // Shell_Sort(arr);


        Integer[] arr = { 27, 53, 79, 12, 5, 7, 86, 45, 34, 85 };
        Shell_Sort(arr);
        show(arr);

    }
}
