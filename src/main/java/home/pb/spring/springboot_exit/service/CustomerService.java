package home.pb.spring.springboot_exit.service;


import home.pb.spring.springboot_exit.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService extends CrudRepository<Customer,Long> {

    @Override
    Customer save(Customer customer);

    @Override
    Iterable<Customer> findAll();

    @Override
    long count();
}
