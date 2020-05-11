package fi.digiprojekti.yummy.domain;

import java.util.List;
/* import java.util.Optional; */

/* import org.springframework.data.jpa.repository.Query; */
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	/* @Query(value="select * from recipe e where e.name like %:keyword%", nativeQuery=true) */
	
	List<Recipe> findByName(@Param("name") String name);
	/* Optional<Recipe> findByKeyword(@Param("keyword") String keyword); */

}
