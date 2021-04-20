package day01.liuyl;

/**
 * @Author: liuyl@cecjiutian.com
 * @DATE: 2021-04-06
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
