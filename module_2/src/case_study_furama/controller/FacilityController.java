package case_study_furama.controller;

import case_study_furama.model.Facility;
import case_study_furama.model.House;
import case_study_furama.model.Villa;
import case_study_furama.service.FacilityService;
import case_study_furama.service.impl.FacilityServiceImpl;

import java.util.Map;

public class FacilityController {
    private FacilityService facilityService= new FacilityServiceImpl();

    public Map<Facility, Integer> getAll(){
        return facilityService.getFacilitys();
    }

    public void saveVilla(Villa villa){
        facilityService.addVilla(villa);
    }

    public void save(Facility facility){
        facilityService.add(facility);
    }

    public void saveHouse(House house){
        facilityService.addHouse(house);
    }

    public Facility getById(int id){
        return facilityService.getById(id);
    }
}
