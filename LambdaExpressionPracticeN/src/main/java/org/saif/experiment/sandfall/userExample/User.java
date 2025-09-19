package org.saif.experiment.sandfall.userExample;

import java.util.Comparator;

public class User implements Comparable<User>{

    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("User{id=%d, name='%s', age=%d}", id, name, age);
    }


    /* ----- natural order: age asc, then name asc ----- */
    // u1 - 30 --> this
    // u2 - 25 --> o
    // this.age - o.age --> 30 - 25 = +5 --> +ve
    // o.age - this.age --> 25 - 30 = -5 --> -ve
    // this.age == o.age == 0
    @Override
    public int compareTo(User o) {
        int ageDiff = this.age - o.age;
        if(age != 0){
            return ageDiff;
        }
        return this.name.compareTo(o.name);
    }

    public static final Comparator<User> BY_NAME = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    };

    public static final Comparator<User> BY_ID_DESC = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o2.id, o1.id);
        }
    };
}
