package case_study_furama.util;

public interface ConstantUtil {
    enum RentType {
        DAY,
        MONTH,
        YEAR
    }

    enum RoomType {
        STANDARD,
        SUPERIOR,
        DELUXE,
        SUITE,
        PRESIDENTIAL
    }

    enum TypeCustomer{
        DIAMOND,
        PLATINIUM,
        GOLC,
        SILVER,
        MEMBER
    }

    enum Degree{
        INTERMEDIATE,
        ASSOCIATE,
        BACHERLOR,
        MASTER,
        DOCTER,
        PROFESSOR
    }

    enum Position{
        Receptionist,
        ATTENDANT,
        SUPERVISOR,
        SECURITY,
        HR,
        SALES,
        DIRECTOR,
        CHEF,
        MANAGER
    }

    enum Gender{
        MALE,
        FEMALE,
        UNKNOW
    }

    interface PATH{
        String EMPLOYEE= "src\\case_study_furama\\data\\employee.csv";
        String CUSTOMER= "src\\case_study_furama\\data\\customer.csv";
        String VILLA= "src\\case_study_furama\\data\\villa.csv";
        String HOUSE= "src\\case_study_furama\\data\\house.csv";
        String ROOM= "src\\case_study_furama\\data\\room.csv";
        String BOOKING= "src\\case_study_furama\\data\\booking.csv";
        String CONTRACT= "src\\case_study_furama\\data\\contract.csv";
    }

}
