package Lab_3.demo.repositories;

import Lab_3.demo.models.Portfolio;
import org.springframework.data.repository.CrudRepository;

public interface Portfolio_Repository extends CrudRepository<Portfolio, Long> {
}
