package com.example.demo.service;

import com.example.demo.dto.AuthorDto;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AuthorService
 *
 * @author Vladimir Polochanin
 */

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorMapper authorMapper;

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorDto create(AuthorDto authorDto) {
        Author author = authorMapper.convertToEntity(authorDto);
        return authorMapper.convertToDto(authorRepository.save(author));
    }

    public AuthorDto getById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return authorMapper.convertToDto(author);
    }

    public AuthorDto update(AuthorDto authorDto) {
        Author author = authorRepository.findById(authorDto.getId()).orElseThrow();
        author = authorMapper.updateAuthorFromDto(authorDto, author);
        return authorMapper.convertToDto(authorRepository.save(author));
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
