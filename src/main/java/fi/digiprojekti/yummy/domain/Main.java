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
@Table(name="main")
public class Main {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "main")
	private List<Recipe> recipes;
	
	public Main() {}
	
	public Main(String name) {
		super();
		this.name = name;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
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
		return "Main [mid=" + mid + ", name=" + name + "]";
	}

}
