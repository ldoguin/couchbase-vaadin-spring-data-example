package hello;

import java.util.List;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

@ViewIndexed(designDoc = "customer")
public interface CustomerRepository extends CouchbasePagingAndSortingRepository<Customer, String> {

	List<Customer> findAll();

	List<Customer> findByLastName(String lastName);

}
