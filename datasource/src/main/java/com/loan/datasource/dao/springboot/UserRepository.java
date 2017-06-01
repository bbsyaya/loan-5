package com.loan.datasource.dao.springboot;

import com.loan.datasource.entities.jpa.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findAll();
    public User findOne(Long id);
    public User save(User todo);
    public void delete(Long id);

}
