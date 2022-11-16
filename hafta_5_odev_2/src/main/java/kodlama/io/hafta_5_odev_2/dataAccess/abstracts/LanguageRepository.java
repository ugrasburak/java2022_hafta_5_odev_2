package kodlama.io.hafta_5_odev_2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hafta_5_odev_2.entities.concretes.Language;


public interface LanguageRepository extends JpaRepository<Language, Integer> {
	boolean existsByLanguageName(String name);
}
