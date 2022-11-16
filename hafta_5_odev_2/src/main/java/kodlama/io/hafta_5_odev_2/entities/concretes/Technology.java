package kodlama.io.hafta_5_odev_2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="technology")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technology_id")
	private int id;
	
	@Column(name="technology_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
}
