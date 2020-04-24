package fi.digiprojekti.yummy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends CrudRepository<Main, Long> {
	
	List<Main> findByName(String name);

}
