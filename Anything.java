/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdRandom;

public class Anything {
    public static void main(String[] args) {

        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        StdRandom.shuffle(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
    // Collection<Integer> c = new ArrayList<>();
    // c.add(1);
    // c.add(2);
    // c.add(3);
    // Iterator<Integer> it = c.iterator();
    // while (it.hasNext()) {
    //     System.out.println(it.next());
    // }
    // System.out.println("----------------");
    // for (Integer i : c) {
    //     System.out.println(i);
    // }
    // System.out.println("----------------");
    // c.forEach(System.out::println);
    // System.out.println("----------------");
    // c.forEach(new Consumer<Integer>() {
    //     public void accept(Integer integer) {
    //         System.out.println(integer);
    //     }
    // });


    // LinkedList<String> list = new LinkedList<>();
    // list.addFirst("first");
    // list.addLast("last");
    // System.out.println(list.removeLast());
    // System.out.println(list.removeLast());


    // ArrayList<Integer> array = new ArrayList<>();
    // array.add(10);
    // array.add(20);
    // for (Integer i : array) {
    //     System.out.println(i);
    // }
    // System.out.println(array.remove(0));
    // System.out.println("-----------------");
    // for (Integer i : array) {
    //     System.out.println(i);
    // }


    // TreeSet<String> t = new TreeSet<>();
    //
    // ArrayList<String>[] arrs = new ArrayList[3];
    // arrs[0] = new ArrayList<>();
    // arrs[1] = new ArrayList<>();
    // arrs[2] = new ArrayList<>();
    // // for (ArrayList<String> arr : arrs) {
    // //     arr = new ArrayList<>();
    // // }
    // arrs[0].add("first");
    // arrs[1].add("2");
    // arrs[2].add("3");
    // for (ArrayList<String> arr : arrs) {
    //     for (String s : arr) {
    //         System.out.println(s);
    //     }
    // }

    // Object[] objs = new Object[10];
    // objs[0] = 1;
    // objs[1] = "a";
    // String[] s = (String[]) objs;
    // for (String string : s) {
    //     System.out.println(string);
    // }

    //     int[] nums = { 2, 3, 4 };
    //     int target = 6;
    //     Arrays.sort(nums);
    //     int[] ans = new int[2];
    //     int flag = 1;
    //     int i = 0;
    //     while ((i < nums.length) && (flag == 1)) {
    //         int l = 0;
    //         int r = nums.length - 1;
    //         while (l <= r) {
    //             int mid = (l + r) / 2;
    //             if (nums[mid] < target - nums[i]) l = mid + 1;
    //             else if (nums[mid] > target - nums[i]) r = mid = 1;
    //             else {
    //                 ans[0] = i;
    //                 ans[1] = mid;
    //                 flag = 0;
    //                 break;
    //             }
    //         }
    //         i++;
    //     }
    //     System.out.println(ans[0]);
    //     System.out.println(ans[1]);
    // }
}
