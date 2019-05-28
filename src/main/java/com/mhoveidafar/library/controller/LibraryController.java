package com.mhoveidafar.library.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mhoveidafar.library.entity.Author;
import com.mhoveidafar.library.repository.IAuthorDAO;
import com.mhoveidafar.library.service.IAuthorService;

@Transactional
@RestController
public class LibraryController {
	
	@Autowired
	private IAuthorService authorService;

	// Create an Author and his/her associated books
	@PostMapping("/create-author")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		
		Author savedAuthor = authorService.save(author);
		return new ResponseEntity<>(savedAuthor, HttpStatus.OK);
	}
	
	
	// Get Author Table values
	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAuthorList() {
		List<Author> list = authorService.findAllAuthor();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@Autowired
	private IAuthorDAO iAuthorDAO;
	
	@DeleteMapping("/author/{fieldID}")
	public void deleteAuthor(@PathVariable Integer fieldID) {
		iAuthorDAO.deleteById(fieldID);
	}
}
