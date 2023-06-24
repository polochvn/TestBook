package com.example.demo.dto;

import lombok.Data;
import org.hibernate.dialect.LobMergeStrategy;

import java.io.Serializable;
import java.util.Date;

/**
 * BookDto
 *
 * @author Vladimir Polochanin
 */
@Data
public class BookDto implements Serializable {

    private Long id;

    private String title;

    private Long pageCount;

    private Date publishDate;

    private Long authorId;
}
