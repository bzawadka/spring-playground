package pl.bzawadka.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.bzawadka.data.Customer;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
