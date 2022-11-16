package kodlama.io.hafta_5_odev_2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hafta_5_odev_2.entities.concretes.Technology;


public interface TechnologyRepository extends JpaRepository<Technology, Integer>{
	
}
