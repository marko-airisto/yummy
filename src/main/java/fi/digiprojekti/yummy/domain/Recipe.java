package fi.digiprojekti.yummy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Reseptin nimeä ei voi jättää tyhjäksi!")
	private String name;
	
	@NotBlank(message = "Lisää reseptissä tarvittavat raaka-aineet!")
	private String ingredient;
	
	@NotBlank(message = "Lisää reseptin valmistusohje!")
	private String instruction;
	
	private String createdby;
	
	@ManyToOne
	@JoinColumn(name = "rid")
	private Regimen regimen;
	
	@ManyToOne
	@JoinColumn(name = "mid")
	private Main main;
	
	public Recipe() {}
	
	public Recipe(String name, String ingredient, String instruction, String createdby) {
		super();
		this.name = name;
		this.ingredient = ingredient;
		this.instruction = instruction;
		this.createdby = createdby;
	}
	
	public Recipe(String name, Regimen regimen, Main main, String ingredient, String instruction, String createdby) {
		super();
		this.name = name;
		this.regimen = regimen;
		this.main = main;
		this.ingredient = ingredient;
		this.instruction = instruction;
		this.createdby = createdby;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Regimen getRegimen() {
		return regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", ingredient=" + ingredient + ", instruction=" + instruction + ", createdby=" + createdby + "]";
	}

}
