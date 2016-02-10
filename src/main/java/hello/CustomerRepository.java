package hello;

import java.util.List;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface CustomerRepository extends CouchbaseRepository<Customer, String> {

	

	List<Customer> findByLastName(String lastName);

}
