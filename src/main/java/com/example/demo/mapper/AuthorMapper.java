package com.example.demo.mapper;

import com.example.demo.dto.AuthorDto;
import com.example.demo.model.Author;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * AuthorMapper
 *
 * @author Vladimir Polochanin
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto convertToDto(Author author);

    Author convertToEntity(AuthorDto authorDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Author updateAuthorFromDto(AuthorDto authorDto, @MappingTarget Author author);
}
