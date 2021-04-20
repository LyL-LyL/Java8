package com.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一：Lambda表达式的基础语法：Java8中引入了一个新的操作符"->"，箭头操作符或者Lambda操作符
 *              ->将Lambda表达式拆分成两部分
 *
 *
 * 左侧：Lambda表达式的【参数列表】，对应【抽象方法的参数列表】
 * 右侧：Lambda表达式中所需要执行的功能，Lambda体。
 *
 * 若此抽象方法是：
 *
 * 语法格式一：无参数、无返回值
 *          ()->System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，无返回值
 *          (x) -> System.out.println(x)
 *
 * 语法格式三：若只有一个参数，小括号可以不写
 *          x -> System.out.println(x);
 *
 * 语法格式四：若有两个参数、有返回值、并且Lambda体中有多条语句
 *
 *          Comparator<Integer> consumer = (x, y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *         };
 *
 * 语法格式五：有两个参数、Lambda体中只有一条用与返回的语句，return 和{}都可以不写
 *             Comparator<Integer> com = (x, y) -> Integer.compare(3, 5);
 *
 * 语法格式六：Lambda 表达式的参数列表中数据类型可以省略不写，
 *                       因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 *
 *
 *   左右遇一括号省
 *   左侧推断类型省
 *
 *
 * 二：Lambda表达式需要【函数式接口】的支持，并且接口中的抽象方法不能多，不然Lambda表达式就不能识别是哪个抽象方法的参数列表。
 *        函数式接口：若接口中只有一个抽象方法、那么此接口就叫【函数式接口】->MyPredicate.java，
 *        可以只用注解【@FunctionalInterface】修饰后判断是否是【函数式接口】
 *
 *
 * @Author: liuyl@cecjiutian.com
 * @DATE: 2021-04-09
 */
public class TestLambda2 {

    @Test
    public void test1() {
        // 用匿名内部类实现接口
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r.run();
        System.out.println("==================================");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }


    /**
     * 有一个参数，无返回值。若只有一个参数，小括号可以不写
     */
    @Test
    public void test02() {
        // Consumer接口的accept方法有一个参数，无返回值。
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("Lambda表达式");
    }

    /**
     * 若有两个参数、有返回值、并且Lambda体中有多条语句
     */
    @Test
    public void test03() {
        Comparator<Integer> consumer = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * 有两个参数、Lambda体中只有一条用与返回的语句，return 和{}都可以不写
     */
    @Test
    public void test04() {
        Comparator<Integer> com = (x, y) -> Integer.compare(3, 5);
    }


    /**
     * 需求：对一个数进行运算。用Lambda表达式需要先有一个函数接口。
     */
    @Test
    public void test05() {

        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        System.out.println(operation(200, (y) -> y + 200));

    }

    public Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }



}















