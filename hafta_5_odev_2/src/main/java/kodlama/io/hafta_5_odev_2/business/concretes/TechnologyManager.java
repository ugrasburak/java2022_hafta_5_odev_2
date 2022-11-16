package kodlama.io.hafta_5_odev_2.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hafta_5_odev_2.business.abstracts.TechnologyService;
import kodlama.io.hafta_5_odev_2.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.hafta_5_odev_2.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.hafta_5_odev_2.business.responses.technologyResponses.GetAllTechnologyResponse;
import kodlama.io.hafta_5_odev_2.dataAccess.abstracts.LanguageRepository;
import kodlama.io.hafta_5_odev_2.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.hafta_5_odev_2.entities.concretes.Language;
import kodlama.io.hafta_5_odev_2.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	
	public TechnologyManager(TechnologyRepository technologyRepository,LanguageRepository languageRepository) {
		this.technologyRepository = technologyRepository;
		this.languageRepository=languageRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies=technologyRepository.findAll();
		List<GetAllTechnologyResponse> getAllTechnologyResponses=new ArrayList<>();
		
		for (Technology technology : technologies) {
			GetAllTechnologyResponse getAllTechnologyResponse=new GetAllTechnologyResponse();
			getAllTechnologyResponse.setId(technology.getId());
			getAllTechnologyResponse.setName(technology.getName());
			getAllTechnologyResponse.setLanguageId(technology.getLanguage().getId());
			getAllTechnologyResponses.add(getAllTechnologyResponse);
		}
		return getAllTechnologyResponses;
	}

	@Override
	public void add(CreateTechnologyRequest request) throws Exception {
		Language language=languageRepository.findById(request.getLanguageId()).orElseThrow(()->new Exception("Programlama dili id'si bulunmuyor"));		
		
		Technology technology=new Technology();
		technology.setName(request.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
		
	}

	@Override
	public void update(UpdateTechnologyRequest request) {
		Language language=languageRepository.findById(request.getLanguageId()).orElseThrow(null);
		
		Technology technology=technologyRepository.findById(request.getId()).orElse(null);
		technology.setName(request.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);
	}

}
