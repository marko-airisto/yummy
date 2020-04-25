package fi.digiprojekti.yummy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Reseptin nimeä ei voi jättää tyhjäksi!")
	private String name;
	
	@NotNull(message = "Anna arvioitu valmistusaika minuutteina!")
	private int preparation;
	
	@NotBlank(message = "Lisää reseptissä tarvittavat raaka-aineet!")
	private String ingredient01;
	
	private String ingredient02, ingredient03, ingredient04, ingredient05, ingredient06, ingredient07, ingredient08;
	private String ingredient09, ingredient10, ingredient11, ingredient12, ingredient13, ingredient14, ingredient15;
	
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
	
	public Recipe(String name, int preparation, String ingredient01, String ingredient02, String ingredient03, String ingredient04, String ingredient05, 
			String ingredient06, String ingredient07, String ingredient08, String ingredient09, String ingredient10, String ingredient11, 
			String ingredient12, String ingredient13, String ingredient14, String ingredient15, String instruction, String createdby) {
		super();
		this.name = name;
		this.preparation = preparation;
		this.ingredient01 = ingredient01;
		this.ingredient02 = ingredient02;
		this.ingredient03 = ingredient03;
		this.ingredient04 = ingredient04;
		this.ingredient05 = ingredient05;
		this.ingredient06 = ingredient06;
		this.ingredient07 = ingredient07;
		this.ingredient08 = ingredient08;
		this.ingredient09 = ingredient09;
		this.ingredient10 = ingredient10;
		this.ingredient11 = ingredient11;
		this.ingredient12 = ingredient12;
		this.ingredient13 = ingredient13;
		this.ingredient14 = ingredient14;
		this.ingredient15 = ingredient15;
		this.instruction = instruction;
		this.createdby = createdby;
	}
	
	public Recipe(String name, int preparation, Regimen regimen, Main main, String ingredient01, String ingredient02, String ingredient03, String ingredient04, 
			String ingredient05, String ingredient06, String ingredient07, String ingredient08, String ingredient09, String ingredient10, 
			String ingredient11, String ingredient12, String ingredient13, String ingredient14, String ingredient15, String instruction, String createdby) {
		super();
		this.name = name;
		this.preparation = preparation;
		this.regimen = regimen;
		this.main = main;
		this.ingredient01 = ingredient01;
		this.ingredient02 = ingredient02;
		this.ingredient03 = ingredient03;
		this.ingredient04 = ingredient04;
		this.ingredient05 = ingredient05;
		this.ingredient06 = ingredient06;
		this.ingredient07 = ingredient07;
		this.ingredient08 = ingredient08;
		this.ingredient09 = ingredient09;
		this.ingredient10 = ingredient10;
		this.ingredient11 = ingredient11;
		this.ingredient12 = ingredient12;
		this.ingredient13 = ingredient13;
		this.ingredient14 = ingredient14;
		this.ingredient15 = ingredient15;
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

	public int getPreparation() {
		return preparation;
	}

	public void setPreparation(int preparation) {
		this.preparation = preparation;
	}

	public String getIngredient01() {
		return ingredient01;
	}

	public void setIngredient01(String ingredient01) {
		this.ingredient01 = ingredient01;
	}
	
	public String getIngredient02() {
		return ingredient02;
	}

	public void setIngredient02(String ingredient02) {
		this.ingredient02 = ingredient02;
	}
	
	public String getIngredient03() {
		return ingredient03;
	}

	public void setIngredient03(String ingredient03) {
		this.ingredient03 = ingredient03;
	}
	
	public String getIngredient04() {
		return ingredient04;
	}

	public void setIngredient04(String ingredient04) {
		this.ingredient04 = ingredient04;
	}
	
	public String getIngredient05() {
		return ingredient05;
	}

	public void setIngredient05(String ingredient05) {
		this.ingredient05 = ingredient05;
	}
	
	public String getIngredient06() {
		return ingredient06;
	}

	public void setIngredient06(String ingredient06) {
		this.ingredient06 = ingredient06;
	}
	
	public String getIngredient07() {
		return ingredient07;
	}

	public void setIngredient07(String ingredient07) {
		this.ingredient07 = ingredient07;
	}
	
	public String getIngredient08() {
		return ingredient08;
	}

	public void setIngredient08(String ingredient08) {
		this.ingredient08 = ingredient08;
	}
	
	public String getIngredient09() {
		return ingredient09;
	}

	public void setIngredient09(String ingredient09) {
		this.ingredient09 = ingredient09;
	}
	
	public String getIngredient10() {
		return ingredient10;
	}

	public void setIngredient10(String ingredient10) {
		this.ingredient10 = ingredient10;
	}
	
	public String getIngredient11() {
		return ingredient11;
	}

	public void setIngredient11(String ingredient11) {
		this.ingredient11 = ingredient11;
	}
	
	public String getIngredient12() {
		return ingredient12;
	}

	public void setIngredient12(String ingredient12) {
		this.ingredient12 = ingredient12;
	}
	
	public String getIngredient13() {
		return ingredient13;
	}

	public void setIngredient13(String ingredient13) {
		this.ingredient13 = ingredient13;
	}
	
	public String getIngredient14() {
		return ingredient14;
	}

	public void setIngredient14(String ingredient14) {
		this.ingredient14 = ingredient14;
	}
	
	public String getIngredient15() {
		return ingredient15;
	}

	public void setIngredient15(String ingredient15) {
		this.ingredient15 = ingredient15;
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
		return "Recipe [id=" + id + ", name=" + name + ", preparation=" + preparation + ", ingredient01=" + ingredient01 + ", ingredient02=" + ingredient02 + ", ingredient03=" + ingredient03 + ", ingredient04=" + ingredient04 + ", ingredient05=" + ingredient05 + ", ingredient06=" + ingredient06 + ", ingredient07=" + ingredient07 + ", ingredient08=" + ingredient08 + ", ingredient09=" + ingredient09 + ", ingredient10=" + ingredient10 + ", ingredient11=" + ingredient11 + ", ingredient12=" + ingredient12 + ", ingredient13=" + ingredient13 + ", ingredient14=" + ingredient14 + ", ingredient15=" + ingredient15 + ", instruction=" + instruction + ", createdby=" + createdby + "]";
	}

}
