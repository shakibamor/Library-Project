package com.mhoveidafar.library.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhoveidafar.library.entity.Author;
import com.mhoveidafar.library.entity.Book;
import com.mhoveidafar.library.repository.IAuthorDAO;
import com.mhoveidafar.library.service.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	IAuthorDAO authorDao;

	@Override
	public List<Author> findAllAuthor() {

		return (List<Author>) authorDao.findAll();
	}

	@Override
	public Author save(Author author) {

		List<Book> books = new ArrayList<>();
		books = author.getBooks();
		Author newAuthor = new Author(author.getName());

		for (int i = 0; i < books.size(); i++) {
			newAuthor.addBook(books.get(i));
		}
		
//		Can replace for with this foreach:
//		books.forEach(x -> newAuthor.addBook(x));
		
		return authorDao.save(newAuthor);
	}

	@Override
	public Author update(Author author) {
		return authorDao.save(author);
	}
}
