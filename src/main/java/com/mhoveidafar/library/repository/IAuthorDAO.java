package com.mhoveidafar.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mhoveidafar.library.entity.Author;

@Repository
public interface IAuthorDAO extends CrudRepository<Author, Integer>{

}
