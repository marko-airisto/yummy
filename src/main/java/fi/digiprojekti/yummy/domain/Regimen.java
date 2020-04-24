package fi.digiprojekti.yummy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="regimen")
public class Regimen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regimen")
	private List<Recipe> recipes;
	
	public Regimen() {}
	
	public Regimen(String name) {
		super();
		this.name = name;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Regimen [rid=" + rid + ", name=" + name + "]";
	}

}
