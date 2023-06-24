package com.example.demo.dto;

import com.example.demo.model.Book;
import lombok.Data;
import java.io.Serializable;
import java.util.Set;

/**
 * AuthorDto
 *
 * @author Vladimir Polochanin
 */
@Data
public class AuthorDto implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private Set<Book> books;

    private Integer age;

}
