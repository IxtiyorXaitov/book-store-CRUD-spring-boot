package dev.ikhtiyor.bookstore.service;

import dev.ikhtiyor.bookstore.entity.Book;
import dev.ikhtiyor.bookstore.payload.ApiResponse;
import dev.ikhtiyor.bookstore.payload.BookDto;
import dev.ikhtiyor.bookstore.repository.BookRepository;
import dev.ikhtiyor.bookstore.utils.AppConstants;
import dev.ikhtiyor.bookstore.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

@Service
public class BookService {

    final
    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ApiResponse create(BookDto request) {
        try {
            boolean exists = bookRepository.existsByName(request.getName());
            if (!exists) {
                Book newBook = new Book();

                newBook.setName(request.getName());
                newBook.setAuthor(request.getAuthor());
                newBook.setPublishedDate(request.getPublishedDate());
                newBook.setPageCount(request.getPageCount());

                bookRepository.save(newBook);
                return ResponseUtils.success(AppConstants.ADDED_SUCCESSFULLY);
            } else {
                return ResponseUtils.error(AppConstants.ALREADY_EXISTS);
            }
        } catch (Exception e) {
            return ResponseUtils.error(AppConstants.SERVER_ERROR);
        }
    }

    public ApiResponse update(Integer id, BookDto request) {
        try {
            boolean exists = bookRepository.existsByNameAndIdNot(request.getName(), id);
            if (!exists) {
                Optional<Book> optionalBook = bookRepository.findById(id);
                if (optionalBook.isPresent()) {
                    Book foundedBook = optionalBook.get();

                    foundedBook.setName(request.getName());
                    foundedBook.setAuthor(request.getAuthor());
                    foundedBook.setPublishedDate(request.getPublishedDate());
                    foundedBook.setPageCount(request.getPageCount());

                    bookRepository.save(foundedBook);
                    return ResponseUtils.success(AppConstants.EDITED_SUCCESSFULLY);

                } else {
                    return ResponseUtils.success(AppConstants.NOT_FOUND);
                }
            } else {
                return ResponseUtils.error(AppConstants.ALREADY_EXISTS);
            }
        } catch (Exception e) {
            return ResponseUtils.error(AppConstants.SERVER_ERROR);
        }
    }

    public ApiResponse getOne(Integer id) {
        try {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                return ResponseUtils.success(book);
            } else {
                return ResponseUtils.success(AppConstants.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseUtils.error(AppConstants.SERVER_ERROR);
        }
    }

    public ApiResponse getAll(Integer page, Integer size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));

            Page<Book> bookPage = bookRepository.findAll(pageRequest);
            return ResponseUtils.successPageable(
                    bookPage.getContent(),
                    bookPage.getTotalPages(),
                    bookPage.getTotalElements()
            );

        } catch (Exception e) {
            return ResponseUtils.errorPageable();
        }
    }

    public ApiResponse delete(Integer id) {
        try {
            bookRepository.deleteById(id);
            return ResponseUtils.success(AppConstants.DELETED_SUCCESSFULLY);
        } catch (Exception e) {
            return ResponseUtils.success(AppConstants.DELETING_ERROR);
        }
    }


}
