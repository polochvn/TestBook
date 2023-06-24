package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;


/**
 * Author
 *
 * @author Vladimir Polochanin
 */
@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", columnDefinition = "varchar(255)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(255)")
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;

    @Column(name = "age", columnDefinition = "integer")
    private Integer age;
}
