package case_study_furama.view;

import case_study_furama.controller.PromotionController;
import case_study_furama.util.CommomUtil;
import case_study_furama.util.ValidationUtil;

public class PromotionView {
    private static PromotionController promotionController= new PromotionController();

    private static void promotionManager(){
        String tmp= "";
        int choice= 0;
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");

            System.out.print(tmp.isEmpty() ? "Input your choice: ": "Please just input number from 1 to 3: ");
            tmp = CommomUtil.getScanner().nextLine();
            if(ValidationUtil.isNumber(tmp)) choice= Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 3);

        switch (choice){
            case 1:
                customberBooking();
                break;
            case 2:
                customerVoucher();
                break;
            case 3:
                break;
        }
    }

    private static void customberBooking(){
        System.out.print("Input year to filter: ");
        int year= Integer.parseInt(CommomUtil.getScanner().nextLine());
        promotionController.getCustomerUseService(year);
        // read
    }

    private static void customerVoucher(){
        System.out.print("Input amount 10% discount voucher: ");
        int amoountOf10 = Integer.parseInt(CommomUtil.getScanner().nextLine());
        System.out.print("Input amount 20% discount voucher: ");
        int amoountOf20 = Integer.parseInt(CommomUtil.getScanner().nextLine());
        System.out.print("Input amount 50% discount voucher: ");
        int amoountOf50 = Integer.parseInt(CommomUtil.getScanner().nextLine());
        promotionController.getCustomerVoucher(amoountOf10, amoountOf20, amoountOf50);
        // read
    }
}
