package main;

import java.util.Arrays;
import java.util.Comparator;

class RunCompare {

    public static void main(String[] args) {

        ComparatorMethod[] ss = {
                new ComparatorMethod(2, "xiaoma2"),
                new ComparatorMethod(1, "xiaoma"),
                new ComparatorMethod(3, "xiaoma3")
        };
        System.out.println(Arrays.toString(ss));
        Arrays.sort(ss, new Comparator<ComparatorMethod>() {
            @Override
            public int compare(ComparatorMethod o1, ComparatorMethod o2) {
                return o1.id - o2.id;
            }
        });
        System.out.println(Arrays.toString(ss));

    }
}

class ComparatorMethod {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ComparatorMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComparableMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class ComparableMethod implements Comparable<ComparableMethod> {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ComparableMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ComparableMethod o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return "ComparableMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
