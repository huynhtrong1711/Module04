package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }

//    @Override
//    public List<Customer> findAll() {
//        TypedQuery<Customer> query = entityManager.createQuery("select s from Customer as s", Customer.class);
//        return query.getResultList();
//    }
}
