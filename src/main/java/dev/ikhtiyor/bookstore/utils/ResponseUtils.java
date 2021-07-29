package dev.ikhtiyor.bookstore.utils;

import dev.ikhtiyor.bookstore.entity.Book;
import dev.ikhtiyor.bookstore.payload.ApiResponse;

import java.util.List;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

public class ResponseUtils {

    public static ApiResponse success(String message, Object object) {
        return new ApiResponse(message, true, object);
    }

    public static ApiResponse success(String message) {
        return new ApiResponse(message, true);
    }

    public static ApiResponse success(Object object) {
        return new ApiResponse(true, object);
    }

    public static ApiResponse success() {
        return new ApiResponse(true);
    }

    public static ApiResponse successPageable(List<Book> bookList, Integer totalPages, Long totalElements) {
        return new ApiResponse(
                true,
                bookList,
                totalElements,
                totalPages
        );
    }

    public static ApiResponse error(String message) {
        return new ApiResponse(message, false);
    }

    public static ApiResponse error() {
        return new ApiResponse(false);
    }

    public static ApiResponse errorPageable() {
        int[] a = {};
        return new ApiResponse(
                false,
                a,
                0L,
                0
        );
    }
}
