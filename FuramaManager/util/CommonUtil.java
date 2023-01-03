package m2_case_study.FuramaManager.util;

import m2_case_study.FuramaManager.model.Person;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtil {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static int getChoice(){
        System.out.print("Enter your choice:");
        return CommonUtil.getScanner().nextInt();
    }

    public static String inputTo(String field){
        System.out.print(field+ ": ");
        return getScanner().nextLine();
    }

    public static Person inputPerson(){
        String fullName = CommonUtil.inputTo("FullName");
        String birthday = CommonUtil.inputTo("Birthday");
        String gender = CommonUtil.inputTo("Gender");
        String phone = CommonUtil.inputTo("Phone");
        String email = CommonUtil.inputTo("Email");
        String address = CommonUtil.inputTo("Address");
        return new Person(fullName, birthday, ConstantUtil.Gender.valueOf(gender.toUpperCase()), phone, email, address);
    }

    public static DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
