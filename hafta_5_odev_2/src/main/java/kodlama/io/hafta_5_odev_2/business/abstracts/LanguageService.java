package kodlama.io.hafta_5_odev_2.business.abstracts;

import java.util.List;

import kodlama.io.hafta_5_odev_2.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.hafta_5_odev_2.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.hafta_5_odev_2.business.responses.languageResponses.GetAllLanguageResponse;

public interface LanguageService {

	List<GetAllLanguageResponse> getAll();
	void add(CreateLanguageRequest request)throws Exception;
	void update(UpdateLanguageRequest request)throws Exception;
	void delete(int id);
}
