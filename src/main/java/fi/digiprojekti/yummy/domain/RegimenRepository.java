package fi.digiprojekti.yummy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimenRepository extends CrudRepository<Regimen, Long> {
	
	List<Regimen> findByName(String name);

}
