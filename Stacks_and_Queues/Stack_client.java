/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Stacks_and_Queues;

import edu.princeton.cs.algs4.Stack;

public class Stack_client {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        Stack<Integer> stack1 = new Stack<>();

        // ded Collections<Integer> c = new ArrayList<>();


    }
}
