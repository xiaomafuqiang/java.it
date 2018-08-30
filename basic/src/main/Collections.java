package main;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class Collections {
    @Test
    public void api() {
        Collection<Integer> c = new ArrayList<>();
        System.out.println(c.add(9));
        System.out.println(c.add(9));

        System.out.println(c.isEmpty());
        System.out.println(c.remove(9));
        System.out.println(c.isEmpty());
        System.out.println(c.size());
        c.clear();
        System.out.println(c.isEmpty());
    }

    @Test
    public void iterator() {
        ArrayList<String> list = new ArrayList<>();
        // list.add("a");
        // list.add("b");
        // list.add("c");
        list.add("d");
        // list.add(9, "p"); // IndexOutOfBoundsException

        // iterator
        // 迭代器便利不能通过list修改
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            // list.add("p"); // ## ConcurrentModificationException
        }
        System.out.println(it.hasNext()); // false

        // listIterator: 双向链表
        ListIterator<String> lt = list.listIterator();
        // lt.add();
        // lt.set();
        // lt.hasPrevious()
        // lt.previous()
        while (lt.hasNext()) {
            System.out.println(lt.next() + ":" + lt.nextIndex()); // nextIndex 不会移动
        }


        for (String aList : list) { // 本质也是 iterator
            System.out.println(aList);
            // list.add("9"); // ## ConcurrentModificationException
        }
    }
}
