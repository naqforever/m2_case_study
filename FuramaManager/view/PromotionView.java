package m2_case_study.FuramaManager.view;

import m2_case_study.FuramaManager.util.CommonUtil;

public class PromotionView {
    public static void show(){
        System.out.println("----- Promotion View: ------\n"+
                "1. Display list customers use service\n"+
                "2. Display list customers get voucher\n"+
                "3. Return main menu");

        int choice= CommonUtil.getChoice();
    }
}
