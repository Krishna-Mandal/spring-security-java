package com.krishna.springsecurityjava.Dao.repo;

import com.krishna.springsecurityjava.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@Qualifier("user")
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUserName(String user);
}
