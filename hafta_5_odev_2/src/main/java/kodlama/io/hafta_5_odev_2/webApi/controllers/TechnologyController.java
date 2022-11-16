package kodlama.io.hafta_5_odev_2.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hafta_5_odev_2.business.abstracts.TechnologyService;
import kodlama.io.hafta_5_odev_2.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.hafta_5_odev_2.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.hafta_5_odev_2.business.responses.technologyResponses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
	
	private TechnologyService technologyService;

	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@PostMapping
	public void add(@RequestBody CreateTechnologyRequest createLanguageRequest) throws Exception {
		technologyService.add(createLanguageRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) {
		technologyService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest)throws Exception{
		technologyService.update(updateTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
}
