package m2_case_study.FuramaManager.view;

import m2_case_study.FuramaManager.model.Facility;
import m2_case_study.FuramaManager.model.House;
import m2_case_study.FuramaManager.model.Room;
import m2_case_study.FuramaManager.model.Villa;
import m2_case_study.FuramaManager.util.CommonUtil;
import m2_case_study.FuramaManager.util.ConstantUtil.RentType;
import m2_case_study.FuramaManager.util.ConstantUtil.RoomType;
import m2_case_study.FuramaManager.controller.FacilityController;

import java.util.Map;

public class FacilityView {
    private static FacilityController facilityController = new FacilityController();

    public static void show(){
        System.out.println("----- Facility View: ------\n"+
                "1. Display list facility\n"+
                "2. Add new facility\n"+
                "3. Display list facility maintenance\n"+
                "4. Return main menu");

        int choice= CommonUtil.getChoice();

        switch (choice) {
            case 1 -> facilityController.findAll().forEach(System.out::println);
            case 2 -> create();
            case 3 -> facilityController.findAllMaintenance().entrySet().forEach(e ->
                System.out.println(e.getKey() + "\nBooking count: " + e.getValue())
            );
            case 4 ->
                HomeView.displayHomeMenu();
        }
    }

    private static void create() {
        System.out.println("1. Add new villa");
        System.out.println("2. Add new house");
        System.out.println("3. Add new room");
        System.out.println("4. Back to menu");

        int choice= CommonUtil.getChoice();

        if(choice == 4){
            show();
        }
        else{
            String code = CommonUtil.inputTo("Code");
            String name = CommonUtil.inputTo("Name");
            double areaUsed = Double.parseDouble(CommonUtil.inputTo("Area Used"));
            double price =  Double.parseDouble(CommonUtil.inputTo("Price"));
            int maxPeople = Integer.parseInt(CommonUtil.inputTo("Max People"));
            String rentType = CommonUtil.inputTo("Rent Type");

            Facility facility = null;
            String roomType;
            int numberOfFloor;

            switch (choice) {
                case 1 -> {
                    roomType = CommonUtil.inputTo("Room Type");
                    double areaPool =  Double.parseDouble(CommonUtil.inputTo("Area Pool"));
                    numberOfFloor = Integer.parseInt(CommonUtil.inputTo("Number Of Floor"));
                    facility = new Villa(code, name, areaUsed, price, maxPeople, RentType.valueOf(rentType.toUpperCase()), RoomType.valueOf(roomType.toUpperCase()), areaPool, numberOfFloor);
                }
                case 2 -> {
                    roomType = CommonUtil.inputTo("Room Type");
                    numberOfFloor = Integer.parseInt(CommonUtil.inputTo("Number Of Floor"));
                    facility = new House( code, name, areaUsed, price, maxPeople, RentType.valueOf(rentType.toUpperCase()),  RoomType.valueOf(roomType.toUpperCase()), numberOfFloor);
                }
                case 3 -> {
                    String freeAttachService = CommonUtil.inputTo("Free Attach Service");
                    facility = new Room( code, name, areaUsed, price, maxPeople, RentType.valueOf(rentType.toUpperCase()), freeAttachService);
                }
            }

            facilityController.create(facility);
            System.out.println("Create successfully!");
        }
    }
}
