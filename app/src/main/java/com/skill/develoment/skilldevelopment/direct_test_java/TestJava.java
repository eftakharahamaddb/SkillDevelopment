package com.skill.develoment.skilldevelopment.direct_test_java;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    private int value1 = 10;
    int value2 = 10;
    protected int value3 = 10;
    public int value4 = 10;

    interface Check {
        void please_check(Person p);
    }

    public int myMethodReturn() {
        try {
            return 8;
        } catch (Exception e) {
            e.printStackTrace();
            return 8;
        } finally {
            return 9;
        }
    }

    static class Person {
        public final int ADULT_AGE = 18;
        public final int ELIGIBLE_FOR_PORN = 15;

        public Person(int age) {
            this.age = age;
        }

        int age;

    }


    public static void main(String[] args) {

        Check c = (p) -> {
            System.out.print(p.age * 45);
        };
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(25));
        personList.add(new Person(15));
        personList.add(new Person(29));
        personList.add(new Person(30));
        personList.forEach(person -> System.out.println(person.age));
        personList.forEach(System.out::println);
    }
}
