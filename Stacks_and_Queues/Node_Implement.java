/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Stacks_and_Queues;

public class Node_Implement {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>();
        Node<Integer> n2 = new Node<>();
        n1.item = 1;
        n1.next = n2;
        n2.item = 2;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
}
