package pl.bzawadka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.bzawadka.data.Customer;
import pl.bzawadka.repository.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        deleteSaveFindInMongoDb();
    }

    private void deleteSaveFindInMongoDb() {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        LOGGER.info("---- Customers found with findAll():");
        repository.findAll().forEach(customer -> LOGGER.info(customer.toString()));

        // fetch an individual customer
        LOGGER.info("---- Customer found with findByFirstName('Alice'):");
        LOGGER.info(repository.findByFirstName("Alice").toString());

        LOGGER.info("---- Customers found with findByLastName('Smith'):");
        repository.findByLastName("Smith").forEach(customer -> LOGGER.info(customer.toString()));
    }
}



