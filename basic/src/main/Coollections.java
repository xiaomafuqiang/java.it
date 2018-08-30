package main;

import main.data.Student;
import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;

public class Coollections {
    @Test
    public void listApi() {
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
    public void ListsIterator() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("d");
        int index = Collections.binarySearch(list, "d");
        System.out.println(index);
        // Collections.fill(list, "---");
        // System.out.println(list);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(""); // dest 长度要大于等于src : IndexOutOfBoundsException: Source does not fit in dest
        list1.add("");
        list1.add("");
        list1.add("");
        list1.add("");
        Collections.copy(list1, list);
        System.out.println(list1+"]]]");
        Collections.reverse(list1);
        System.out.println(list1+"[[[");
        Collections.shuffle(list1);
        System.out.println(list);
        System.out.println(list1);
        // list.add(9, "p"); // IndexOutOfBoundsException


        /*
        * asList
        *
        * */
        String[] strings = new String[]{"1", "2"};
        List<String> alist = Arrays.asList(strings);
        System.out.println(alist);
        strings[0] = "changed";
        System.out.println(alist);
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

    @Test
    public void setApi() {
        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("a"));
        System.out.println(hashSet.add("a"));
        System.out.println(hashSet.add("b"));
        System.out.println(hashSet.add("c"));

        // toArray
        String[] sArr = hashSet.toArray(new String[]{});
        System.out.println(sArr.length);

    }


    @Test
    public void runHashEqual() {
        HashSet<Student> hashSet = new HashSet<>();
        System.out.println(hashSet.add(new Student("a", 1)));
        boolean isTrue = hashSet.add(new Student("a", 1));
        System.out.println(isTrue);
        System.out.println(hashSet.add(new Student("b", 2)));
    }


    @Test
    public void apiTreeSet() {
        TreeSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        System.out.println(set);
    }

    @Test
    public void apiMap() {
        HashMap<String, String> map = new HashMap<>();
        String isPutted = map.put("a", "a");
        System.out.println(isPutted);
        isPutted = map.put("b", "b");
        System.out.println(isPutted);
        isPutted = map.put("b", "bb");
        System.out.println(isPutted);

        // 遍历
        System.out.println("遍历----->>>>");
        String sb = map.get("b");
        System.out.println(sb);
        System.out.println(map.entrySet());
        for (Map.Entry<String, String> entry:
            map.entrySet()){
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        Set<Entry<String, String>> setEntries = map.entrySet();
        System.out.println("遍历----->>>>");

        // keys
        Set<String> set = map.keySet();
        // set.clear(); // 会影响map
        // set.add(error); // UnsupportedOperationException 不支持 因为同步map需要 key-> value;
        for (String ss :
                set) {
            System.out.println(ss);
        }

        // values
        Collection<String> c = map.values();
        c.remove("a"); // 会影响map
        // c.add(error); // UnsupportedOperationException 不支持 因为同步map需要 key-> value;
        System.out.println(c);
        System.out.println(map);
    }
}

