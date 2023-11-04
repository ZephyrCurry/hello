package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("added item is null!!");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) last = first;
        N++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("added item is null!!");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException("the deque is empty!!");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException("the deque is empty!!");
        Node temp = first;
        if (temp.next == null) {
            Item item = temp.item;
            temp = null;
            first = null;
            last = null;
            N--;
            return item;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Item item = temp.next.item;
        temp.next = null;
        if (isEmpty()) first = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (isEmpty()) throw new java.util.NoSuchElementException("the deque is empty!!");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Don't use the method!!");
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addLast("last1");
        deque.addLast("last2");
        deque.addLast("last3");
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.removeLast();
        Iterator<String> itr = deque.iterator();
        while (itr.hasNext()) {
            StdOut.println(itr.next());
        }
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.size());
    }
}