package datastructure;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class WLinkedListTest {

    @Test
    public void add() {
    }

    @Test
    public void add1() {
        WLinkedList<Integer> linkedList = new WLinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(0, 11111);
        linkedList.remove();
        System.out.println(linkedList.get(2));
    }
}