package dev.ikhtiyor.bookstore.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private String message;
    private boolean success;
    private Object object;

    private Long totalElements;
    private Integer totalPages;

    public ApiResponse() {
    }

    public ApiResponse(String message, boolean success, Object object, Long totalElements, Integer totalPages) {
        this.message = message;
        this.success = success;
        this.object = object;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public ApiResponse(boolean success, Object object, Long totalElements, Integer totalPages) {
        this.success = success;
        this.object = object;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(boolean success, Object object) {
        this.success = success;
        this.object = object;
    }

    public ApiResponse(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public ApiResponse(boolean success) {
        this.success = success;
    }
}
