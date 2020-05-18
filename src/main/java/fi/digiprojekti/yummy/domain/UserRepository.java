package fi.digiprojekti.yummy.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	User findByFirstname(String firstname);
	User findByLastname(String lastname);

}