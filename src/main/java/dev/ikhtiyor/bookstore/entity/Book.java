package dev.ikhtiyor.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private Integer id;

    @Column(
            name = "name",
            nullable = false,
            unique = true
    )
    private String name;

    @Column(
            name = "published_date",
            nullable = false
    )
    private String publishedDate;

    @Column(
            name = "author",
            nullable = false
    )
    private String author;

    @Column(
            name = "page_count",
            nullable = false
    )
    private Integer pageCount;
}
