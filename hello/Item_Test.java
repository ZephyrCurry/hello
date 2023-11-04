/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package hello;

public class Item_Test {
    public static void main(String[] args) {
        InterImplement2<Integer> in2 = new InterImplement2<>();
        in2.show(4);
        System.out.println(InterImplement2.use());
    }
}

interface Inter<E> {
    public void show(E i);
}

class InterImplement1 implements Inter<String> {
    public void show(String s) {
        System.out.println(s);
    }
}

class InterImplement2<E> implements Inter<E> {
    private String s;

    public void show(E e) {
        System.out.println(e);
    }

    public void set(String s) {
        this.s = s;
    }

    public void print() {
        System.out.println(s);
    }

    public static String use() {
        return "HelloWorld";
    }
}

