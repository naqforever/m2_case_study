package m2_case_study.FuramaManager.model;

import m2_case_study.FuramaManager.util.ConstantUtil.RentType;

public abstract class Facility {
    private String name;
    private double areaUsed;
    private double price;
    private int maxPeople;
    private RentType rentType;
}
