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

        int choice= CommonUtil.getChoice(1,4);

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

        int choice= CommonUtil.getChoice(1,4);

        if(choice == 4){
            show();
        }
        else{
            String code = CommonUtil.inputWithOutEmpty("Code");
            String name = CommonUtil.inputWithOutEmpty("Name");
            double areaUsed = Double.parseDouble(CommonUtil.inputWithOutEmpty("Area Used"));
            double price =  Double.parseDouble(CommonUtil.inputWithOutEmpty("Price"));
            int maxPeople = CommonUtil.inputToInteger("Max People");
            RentType rentType = CommonUtil.inputToEnum(RentType.class, "Rent Type");

            Facility facility = null;
            RoomType roomType;
            int numberOfFloor;

            switch (choice) {
                case 1 -> {
                    roomType = CommonUtil.inputToEnum(RoomType.class , "Room Type");
                    double areaPool =  CommonUtil.inputToDouble("Area Pool");
                    numberOfFloor = CommonUtil.inputToInteger("Number Of Floor");
                    facility = new Villa(code, name, areaUsed, price, maxPeople, rentType, roomType, areaPool, numberOfFloor);
                }
                case 2 -> {
                    roomType = CommonUtil.inputToEnum(RoomType.class , "Room Type");
                    numberOfFloor = CommonUtil.inputToInteger("Number Of Floor");
                    facility = new House( code, name, areaUsed, price, maxPeople, rentType, roomType, numberOfFloor);
                }
                case 3 -> {
                    String freeAttachService = CommonUtil.inputWithOutEmpty("Free Attach Service");
                    facility = new Room( code, name, areaUsed, price, maxPeople, rentType, freeAttachService);
                }
            }

            facilityController.create(facility);
            System.out.println("Create successfully!");
        }
    }
}
