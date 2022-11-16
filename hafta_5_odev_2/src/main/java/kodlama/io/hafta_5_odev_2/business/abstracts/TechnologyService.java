package kodlama.io.hafta_5_odev_2.business.abstracts;

import java.util.List;

import kodlama.io.hafta_5_odev_2.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.hafta_5_odev_2.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.hafta_5_odev_2.business.responses.technologyResponses.GetAllTechnologyResponse;

public interface TechnologyService {
	
	List<GetAllTechnologyResponse> getAll();
	void add(CreateTechnologyRequest request)throws Exception;
	void update(UpdateTechnologyRequest request)throws Exception;
	void delete(int id);
}
