package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import org.mapstruct.*;

/**
 * BookMapper
 *
 * @author Vladimir Polochanin
 */

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authorId", expression = "java(book.getAuthor().getId())")
    BookDto convertToDto(Book book);

    Book convertToEntity(BookDto bookDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book updateBookFromDto(BookDto bookDto, @MappingTarget Book book);
}
