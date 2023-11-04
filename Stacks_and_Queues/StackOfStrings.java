/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Stacks_and_Queues;

public class StackOfStrings {

    private static String[] str;

    private int count;

    StackOfStrings() {
        str = new String[100];
    }

    public void push(String s) {
        str[count++] = s;
    }

    public String pop() {
        return str[--count];
    }

    public boolean isEmpty() {
        if (count == 0) return true;
        return false;
    }

    public int size() {
        return count;
    }
}
