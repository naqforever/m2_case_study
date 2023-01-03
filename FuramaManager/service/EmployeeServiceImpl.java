package m2_case_study.FuramaManager.service;

import m2_case_study.FuramaManager.model.Employee;
import m2_case_study.FuramaManager.util.ConstantUtil.Gender;
import m2_case_study.FuramaManager.util.ConstantUtil.Position;
import m2_case_study.FuramaManager.util.ConstantUtil.Degree;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("E1", "Quoc Nguyen", "23/09/1984", Gender.MALE, "0708230984",
                "quocnna@gmail.com", "19 Le Do", Degree.BACHELOR, Position.SUPERVISOR, 2000));
        employees.add(new Employee("E2", "Dung Nguyen", "05/05/1995", Gender.MALE, "0708230984",
                "dungnna@gmail.com", "19 Le Do", Degree.DOCTOR, Position.SUPERVISOR, 3000));
        employees.add(new Employee("E3", "Toan Nguyen", "03/03/1991", Gender.MALE, "0708230984",
                "toannna@gmail.com", "19 Le Do", Degree.PROFESSOR, Position.SUPERVISOR, 4000));
    }

    @Override
    public void create(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(Employee employee) {
        int index = employees.indexOf(employee);
        employees.set(index, employee);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
