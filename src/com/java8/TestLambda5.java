package com.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java中内置的4大函数式接口(接口中只有一个抽象方法)
 *
 * Consumer<T>：消费型接口
 *      void accept(T t);
 *
 * Supplier<T>：供给型接口
 *      T get();
 *
 * Function<T,R>：函数式接口
 *      R apply(T t);
 *
 * Predicate<T>：断言型接口
 *      boolean test(T t)
 *
 *
 * @Author: liuyl@cecjiutian.com
 * @DATE: 2021-04-20
 */
public class TestLambda5 {

    /**
     * Consumer<T>：消费型接口：void accept(T t)，没有返回值。
     */
    @Test
    public void testConsumer() {
        happy(1000, (m) -> System.out.println("消费了" + m + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Supplier<T>：供给型接口：T get();
     * 需求：产生指定个数的整数，并放入集合中
     */
    @Test
    public void testSupplier() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //Lambda表达式返回的值
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Function<T,R>：函数式接口，R apply(T t);
     * 需求：用于处理字符串,->右侧是要处理的方式
     */

    @Test
    public void testFunction() {
        String s = strHangler("\t\t\t厉害   ", (str) -> str.trim());
        System.out.println(s);

        String string = strHangler("厉害了啧啧啧", (str) -> str.substring(1, 2));
        System.out.println(string);
    }

    public String strHangler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicate<T>：断言型接口,boolean test(T t)
     * 将满足条件的字符串添加到集合中
     */
    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("Hello", "Lambda", "www", "Ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        for (String s : strList) {
            System.out.println(s);
        }
    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        //把满足条件的集合放入到strList中
        List<String> strList = new ArrayList<>();
        //遍历list集合，以方进行过滤
        for (String str : list) {
            if (predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;

    }

}





