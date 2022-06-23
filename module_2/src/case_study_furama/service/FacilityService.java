package case_study_furama.service;

import case_study_furama.model.Facility;
import case_study_furama.model.House;
import case_study_furama.model.Room;
import case_study_furama.model.Villa;

import java.util.Map;

public interface FacilityService {
    void addVilla(Villa villa);
    void addHouse(House house);
    void addRoom(Room room);
    void add(Facility f);
    Map<Facility, Integer> getFacilitys();
    Facility getById(int id);
}
