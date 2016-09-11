/**
 * 
 */
package com.mursil.service.model;

import org.springframework.data.repository.CrudRepository;

/**
 * DataAccess Object for Customer Entity
 * 
 * @author Mursil
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
