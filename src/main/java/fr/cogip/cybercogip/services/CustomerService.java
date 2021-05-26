package fr.cogip.cybercogip.services;

import fr.cogip.cybercogip.data.CustomerRepository;
import fr.cogip.cybercogip.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final  CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //pour lister tous les clients
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    //la fonctionalité d'ajouter un client
    public void addCustomer(Customer customer){ if (!customerRepository.existsById(customer.getId())){
     customerRepository.save(customer);
    }
    //la fonctionalité de suppromer un client
    /*public void deleteCustomer(Customer customer){ if (!customerRepository.existsById(customer.getId())){
        customerRepository.delete(customer);
        }

        }*/
    }
}
