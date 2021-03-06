package es.upm.miw.apaw_practice.domain.services.sportyRental;

import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.CustomerSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CustomerSportyService {

    private CustomerSportyPersistence customerSportyPersistence;

    @Autowired
    public CustomerSportyService(CustomerSportyPersistence customerSportyPersistence) {
        this.customerSportyPersistence = customerSportyPersistence;
    }

    public void deleteByDni(String dni) {
        this.customerSportyPersistence.deleteByDni(dni);
    }

    public Stream<String> readDescriptionsCategoryByCustomerName(String name) {
        return this.customerSportyPersistence.readDescriptionsCategoryByCustomerName(name);
    }
}
