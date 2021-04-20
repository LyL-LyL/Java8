package day01.liuyl;

/**
 * @Author: liuyl@cecjiutian.com
 * @DATE: 2021-04-06
 */

@FunctionalInterface    // 此注解可以判断接口是否是函数式接口，接口中只含有一个抽象方法，所以是
public interface MyPredicate<T> {

    public boolean test(T t);

}
