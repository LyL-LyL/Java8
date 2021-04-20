package com.java8;

import org.junit.Test;

import java.util.*;

/**
 * @Author: liuyl@cecjiutian.com
 * @DATE: 2021-04-05
 */
public class TestLambda {

    // 1、原来的匿名内部类
    @Test
    public void test01() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO: 真正核心的代码
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> tr = new TreeSet<>(com);
    }

    // 2、用lambda表达式比较
    @Test
    public void test02() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> tr = new TreeSet<>(com);
    }

    // 3、需求：获取公司中员工年龄大于35的员工信息
    // 将数组转为集合

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

//    @Test
//    public void test03() {
//        List<Employee> list = filterEmployee(this.employees);
//        for (Employee employee : list) {
//            System.out.println(employee);
//        }
//    }
    // 获取年龄大大于35岁的员工信息
//    public List<Employee> filterEmployee(List<Employee> list) {
//        List<Employee> eps = new ArrayList<>();
//        for (Employee ep : list) {
//            if (ep.getAge() >= 35) {
//                eps.add(ep);
//            }
//        }
//        return eps;
//    }


    // 优化方式一：策略设计模式。获取年龄大大于35岁的员工信息、工资大于5000，接口+实现类
    @Test
    public void test04() {
        List<Employee> list = filterEmployee(this.employees, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("=================================");

        List<Employee> list2 = filterEmployee(this.employees, new FilterEmployeeBySalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }


    // 优化方式二：匿名内部类
    @Test
    public void test05() {
        List<Employee> list = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                // 核心代码
                return employee.getSalary() <= 5000;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }

    }

    // 优化方式三：Lambda表达式
    @Test
    public void test06() {
        List<Employee> list = filterEmployee(this.employees, (e) -> e.getSalary() <= 5000);
        for (Employee employee : list) {
            list.forEach(System.out::println);
        }
    }

    // 优化方式四：Stream API。假设接口和两个实现类都没有，以上代码也没有。只有对应的员工信息集合。
    @Test
    public void test07() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000) //过滤出工资大于5000的
                .limit(2)  // 只取前两个
                .forEach(System.out::println);

        System.out.println("==============================================");

        employees.stream()
                .map(Employee::getName) // 获取员工姓名
                .forEach(System.out::println);
    }


}
