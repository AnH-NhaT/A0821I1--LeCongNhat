package final_test.dao;

import java.util.List;

public interface CustomerDAO {
	
	void insertFromCSV();
	
	List<?> getData();
	
	void update();
	
	void delete();
}
