package m2_case_study.FuramaManager.service;

import m2_case_study.FuramaManager.model.Customer;
import m2_case_study.FuramaManager.util.ConstantUtil.Gender;
import m2_case_study.FuramaManager.util.ConstantUtil.TypeCustomer;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private static List<Customer> customers = new LinkedList<>();

    static {
        customers.add(new Customer("C1", "Phong Nguyen", "23/09/1984", Gender.MALE, "0708230984",
                "phongnna@gmail.com", "19 Le Do", TypeCustomer.SILVER));
    }

    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void update(Customer customer) {
        int index = customers.indexOf(customer);
        customers.set(index, customer);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
