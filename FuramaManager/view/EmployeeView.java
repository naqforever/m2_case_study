package m2_case_study.FuramaManager.view;

import m2_case_study.FuramaManager.controller.EmployeeController;
import m2_case_study.FuramaManager.model.Employee;
import m2_case_study.FuramaManager.model.Person;
import m2_case_study.FuramaManager.util.CommonUtil;
import m2_case_study.FuramaManager.util.ConstantUtil.Degree;
import m2_case_study.FuramaManager.util.ConstantUtil.Position;

public class EmployeeView {
    private static EmployeeController employeeController = new EmployeeController();

    public static void show(){
            System.out.println("----- Employee View: ------\n"+
                    "1. Display list employees\n"+
                    "2. Add new employee\n"+
                    "3. Edit employee\n"+
                    "4. Return main menu");

        int choice= CommonUtil.getChoice(1,4);

        switch (choice) {
            case 1 -> employeeController.findAll().forEach(System.out::println);
            case 2 -> {
                String code = CommonUtil.inputWithOutEmpty("Code");
                Employee newEmployee = input();
                newEmployee.setCode(code);
                employeeController.create(newEmployee);
                System.out.println("Create successfully...!");
            }
            case 3 -> {
                System.out.print("Input code to edit: ");
                String editCode = CommonUtil.getScanner().nextLine();
                Employee editEmployee = input();
                editEmployee.setCode(editCode);
                employeeController.update(editEmployee);
                System.out.println("Update successfully...!");
            }
            case 4 -> HomeView.displayHomeMenu();
        }
    }

    private static  Employee input() {
        Person person = CommonUtil.inputPerson();
        Degree degree = CommonUtil.inputToEnum(Degree.class,"Degree");
        Position position = CommonUtil.inputToEnum(Position.class, "Position");
        double salary = CommonUtil.inputToDouble("Salary");

        return new Employee(person.getFullName(), person.getBirthday(), person.getGender(), person.getPhone(), person.getEmail(), person.getAddress(), degree, position, salary);
    }
}
