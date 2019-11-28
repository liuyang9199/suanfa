package com.liuyang.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/24 下午10:04
 */
public class TestLambda {

    public static void main(String[] args) {
        List<Student> students = Stream.of(new Student("路飞", 22),
                new Student("宏发", 40), new Student("白胡子", 50))
                .collect(Collectors.toList());

        List<Student> students3 = Stream.of(new Student("路飞3", 22),
                new Student("宏发3", 40), new Student("白胡子3", 50))
                .collect(Collectors.toList());

        System.out.println(students);

        List<Student> students1 = students.stream().filter(str -> str.getAge() > 30).collect(Collectors.toList());

        System.out.println(students1);

        List<String> list = students.stream().map(str->str.getName()).collect(Collectors.toList());
        System.out.println(list);

        List<Student> list3 = Stream.of(students, students3).flatMap(u -> u.stream()).collect(Collectors.toList());
        System.out.println(list3);

        Optional<Student> max = students.stream().max(Comparator.comparing(s->s.getAge()));
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        Optional<Student> max1 = Optional.ofNullable(null);
        if (max1.isPresent()) {
            System.out.println(max1.get());
        } else {
            System.out.println(max1.orElseGet(()->new Student("",3)));
        }
    }

}
