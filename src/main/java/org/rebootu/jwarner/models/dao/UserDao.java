package org.rebootu.jwarner.models.dao;

import org.rebootu.jwarner.models.AbstractEntity;
import org.rebootu.jwarner.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by Joseph on 6/1/2015.
 */
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUserName(String userName);

    User findByUid(int uid);

}


