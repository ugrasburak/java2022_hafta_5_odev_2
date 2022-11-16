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

import kodlama.io.hafta_5_odev_2.business.abstracts.LanguageService;
import kodlama.io.hafta_5_odev_2.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.hafta_5_odev_2.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.hafta_5_odev_2.business.responses.languageResponses.GetAllLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest)throws Exception{
		languageService.update(updateLanguageRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
}
