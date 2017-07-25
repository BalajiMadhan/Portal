package com.portal.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.portal.enitity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Serializable> {


	
	Login findOneByUserName(String userName);
}
