package com.yupi.yupao.once;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Person> array = Arrays.asList(
                new Person(1, "下王", 19),
                new Person(2, "heihei", 10),
                new Person(3, "大伯伯", 20),
                new Person(4, "下王", 25)
        );
        array.stream()

                .filter(person -> person.getAge()>18)
                .limit(3)
                .distinct()
//                .skip(1)
                .sorted(Comparator.comparing(Person::getAge).reversed())
//                .map(person -> person.getName())

                .collect(Collectors.groupingBy(Person::getName))
                .forEach((k,v) -> System.out.println("k:"+k+"v:"+v));
    }
}
