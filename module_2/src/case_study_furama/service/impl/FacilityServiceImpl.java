package case_study_furama.service.impl;

import case_study_furama.model.Facility;
import case_study_furama.model.House;
import case_study_furama.model.Room;
import case_study_furama.model.Villa;
import case_study_furama.service.FacilityService;
import case_study_furama.util.ConstantUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilitys= new LinkedHashMap<>();

    static {
        House house= new House( "HOU01", "Sweet House", 5, 55555, 5,
                ConstantUtil.RentType.MONTH, ConstantUtil.RoomType.STANDARD, 3);

        Villa villa= new Villa("VIL01", "Aston Villa", 12, 123, 10, ConstantUtil.RentType.MONTH, ConstantUtil.RoomType.DELUXE,  234, 3);
        house.setId(1);
        villa.setId(2);
        Villa villa2= new Villa("VIL02", "Aston Villa", 12, 123, 10, ConstantUtil.RentType.MONTH, ConstantUtil.RoomType.DELUXE,  234, 3);
        villa2.setId(3);
        facilitys.put( house, 1);
        facilitys.put(villa,2);
        facilitys.put(villa2, 2);
    }

    @Override
    public Map<Facility, Integer> getFacilitys() {
        return facilitys;
    }

    @Override
    public Facility getById(int id) {
        return facilitys.keySet().stream().filter(e-> id== e.getId()).findFirst().get();
    }

    @Override
    public void addVilla(Villa villa) {
        villa.setId(facilitys.size()+ 1);
        facilitys.put(villa, 2);
    }

    @Override
    public void addHouse(House house) {
        house.setId(facilitys.size()+ 1);
        facilitys.put(house, 0);
    }

    @Override
    public void addRoom(Room room) {

    }

    @Override
    public void add(Facility f) {
        f.setId(facilitys.size()+ 1);
        int count= 0;
        for (Entry<Facility, Integer> e : facilitys.entrySet()) {
            boolean a= f instanceof Villa;
            boolean b= e.getKey() instanceof Villa;
//            boolean c = e.getKey() instanceof f;
            if(f instanceof Villa && e.getKey() instanceof Villa){
                count= e.getValue();
                e.setValue(++count);
            }

            if(f instanceof House && e.getKey() instanceof House){
                count= e.getValue();
                e.setValue(++count);
            }
        }


//        int aaa= facilitys.entrySet().stream().skip(facilitys.size()-1).findFirst().get().getValue();
        facilitys.put(f, count);
    }
}
