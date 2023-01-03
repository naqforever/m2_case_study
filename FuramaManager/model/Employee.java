package m2_case_study.FuramaManager.model;

import m2_case_study.FuramaManager.util.ConstantUtil;
import m2_case_study.FuramaManager.util.ConstantUtil.Degree;
import m2_case_study.FuramaManager.util.ConstantUtil.Position;

public class Employee extends Person {
    private Degree degree;
    private Position position;
    private double salary;

    public Employee(Degree degree, Position position, double salary) {
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String code, String fullName, String birthday, ConstantUtil.Gender gender, String phone, String email, String address, Degree degree, Position position, double salary) {
        super(code, fullName, birthday, gender, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        String code = ((Employee) obj).getCode();
        return getCode().equalsIgnoreCase(code);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "degree=" + degree +
                ", position=" + position +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
