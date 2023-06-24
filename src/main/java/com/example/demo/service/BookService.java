package com.example.demo.service;

import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BookService
 *
 * @author Vladimir Polochanin
 */

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    private final AuthorMapper authorMapper;

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public BookDto create(Long id, BookDto bookDto) {
        bookDto.setAuthorId(id);
        Book book = bookMapper.convertToEntity(bookDto);
        Author author = authorRepository.findById(id).orElseThrow();
        book.setAuthor(author);
        Set<Book> bookSet = author.getBooks() != null ? author.getBooks() : new HashSet<>();
        bookSet.add(book);
        author.setBooks(bookSet);
        authorRepository.save(author);
        return bookMapper.convertToDto(bookRepository.save(book));
    }

    public BookDto getById(Long id, Long bookId) {
        return bookMapper.convertToDto(bookRepository.findById(bookId).orElseThrow());
    }

    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookDto update(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow();
        book = bookMapper.updateBookFromDto(bookDto, book);
        return bookMapper.convertToDto(bookRepository.save(book));
    }
}
