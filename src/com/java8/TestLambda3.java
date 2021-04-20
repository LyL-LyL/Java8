package com.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @Author: liuyl@cecjiutian.com
 * @DATE: 2021-04-15
 */
public class TestLambda3 {


    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /**
     * 调用Collections.sort()方法，通过定制排序比较两个Employee(先按年龄比，
     * 年龄相同按姓名比)，使用Lambda表达式作为参数传递
     */
    @Test
    public void test01() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }


    @Test
    public void test02() {
        String s = strHandler("llll 哈哈哈", (str) -> str.toUpperCase());
        System.out.println(s);
    }

    // 需求：用于将字符串处理成大写
    public String strHandler(String str, MyFunction mf) {
        return mf.getVAlue(str);

    }


    @Test
    public void test03() {
        op(100L, 200L, (x, y) -> x + y);
        op(25L, 4L, (x, y) -> x *  y);
    }

    //需求：对于两个Long进行处理
    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }


}
