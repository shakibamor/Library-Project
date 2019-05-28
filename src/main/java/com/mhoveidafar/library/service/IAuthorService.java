package com.mhoveidafar.library.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mhoveidafar.library.entity.Author;

@Service
public interface IAuthorService {
	
	List<Author> findAllAuthor();

	Author save(Author author);

	Author update(Author author);
}
