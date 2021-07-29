package dev.ikhtiyor.bookstore.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Published Date is mandatory")
    private String publishedDate;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotNull(message = "Page Count is mandatory")
    private Integer pageCount;
}
