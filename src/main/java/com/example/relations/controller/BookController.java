package com.example.relations.controller;


import com.example.relations.onetoone.Book;
import com.example.relations.onetoone.BookDetail;
import com.example.relations.repository.BookDetailRepository;
import com.example.relations.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Wei
 * @date 04.04.20
 */

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final BookDetailRepository bookDetailRepository;

    @GetMapping( value = "/book/bestWayToAddABookDetail" )
    private void bestWayToAddABookDetail() {
        final String bookName = "Java digging1";
        final String bookAuthor = "Wei Wang1";

        Book book = Book.builder().bookName(bookName).build();
        BookDetail bookDetail = BookDetail.builder().bookAuthor(bookAuthor).book(book).build();

        bookDetailRepository.save(bookDetail);

//        Hibernate: insert into book (book_name) values (?)
//        Hibernate: insert into book_detail (book_author, book_id) values (?, ?)

    }

    @GetMapping( value = "/book/addABookDetailWithTwoSteps" )
    private void addABookDetailWithTwoSteps() {
        final String bookName = "Java digging2";
        final String bookAuthor = "Wei Wang2";

        Book book = Book.builder().bookName(bookName).build();
        BookDetail bookDetail = BookDetail.builder().bookAuthor(bookAuthor).book(book).build();

        bookRepository.save(book);
        //Hibernate: insert into book (book_name) values (?)

        bookDetailRepository.save(bookDetail);
        //Hibernate: insert into book_detail (book_author, book_id) values (?, ?)
    }

    @GetMapping( value = "/book/addABookWithTwoBookdetailsWillFail" )
    private void addABookWithTwobookdetails() {
        final String bookName = "Java digging1";
        final String bookAuthor = "Wei Wang 1";
        final String bookAuthor2 = "Wei Wang 2";

        Book book = Book.builder().bookName(bookName).build();
        BookDetail bookDetail1 = BookDetail.builder().bookAuthor(bookAuthor).book(book).build();


        bookDetailRepository.save(bookDetail1);
//        Hibernate: insert into book (book_name) values (?)
//        Hibernate: insert into book_detail (book_author, book_id) values (?, ?)

        BookDetail bookDetail2 = BookDetail.builder().bookAuthor(bookAuthor).book(book).build();

        bookDetailRepository.save(bookDetail2);
        //javax.persistence.EntityExistsException: A different object with the same identifier value was already associated with the session

    }

    @GetMapping( value = "/book/addABookWithoutBookDetailIsFine" )
    private void addABookWithoutBookDetail() {
        final String bookName = "Java digging1";
        final String bookAuthor = "Wei Wang 1";

        Book book = Book.builder().bookName(bookName).build();

        bookRepository.save(book);
        //Hibernate: insert into book (book_name) values (?)

    }


    @GetMapping( value = "/book/searchBookdetail" )
    private void searchBookdetail(Long id) {

        bookDetailRepository.findById(id);
        //Hibernate: select bookdetail0_.book_id as book_id2_1_0_, bookdetail0_.book_author as book_aut1_1_0_ from book_detail bookdetail0_ where bookdetail0_.book_id=?

    }

    @GetMapping( value = "/book/searchBook" )
    private void searchBook(Long id) {

        Book book = bookRepository.findById(id).get();
        //Hibernate: select book0_.id as id1_0_0_, book0_.book_name as book_nam2_0_0_ from book book0_ where book0_.id=?

    }

    @DeleteMapping( value = "/book/deleteBook" )
    private void delete(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if ( optionalBook.isPresent() ) {
            bookRepository.deleteById(id);
        }

//        Hibernate:
//        select
//        book0_.id as id1_0_0_,
//                book0_.book_name as book_nam2_0_0_
//        from
//        book book0_
//        where
//        book0_.id=?
//
//        Hibernate:
//        delete
//                from
//        book
//                where
//        id=?

    }

    @DeleteMapping( value = "/book/deleteBookDetail" )
    private void deleteBookDetail(Long id) {

        // deleting something doesnt exist will cause error : org.springframework.dao.EmptyResultDataAccessException: No class com.example.relations.onetoone.BookDetail entity with id 10 exists!

        Optional<BookDetail> optionalBookDetail = bookDetailRepository.findById(id);
        //        select
        //        bookdetail0_.book_id as book_id2_1_0_,
        //                bookdetail0_.book_author as book_aut1_1_0_
        //        from
        //        book_detail bookdetail0_
        //        where
        //        bookdetail0_.book_id=?
        //        Hibernate:
        //        delete
        //                from
        //        book_detail
        //                where
        //        book_id=?
        if ( optionalBookDetail.isPresent() ) {
            bookDetailRepository.deleteById(id);
        }
    }


    @GetMapping( value = "/book/updateBook" )
    private void updateBook(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if ( optionalBook.isPresent() ) {
            Book update = optionalBook.get();

            update.setBookName("Java update");
            bookRepository.save(update);

//            Hibernate:
//            update
//                    book_detail
//            set
//            book_author=?
//            where
//            book_id=?
        }
    }

        @GetMapping( value = "/book/updateBookDetail" )
        private void updateBookDetail(Long id){

            Optional<BookDetail> optionalBookDetail = bookDetailRepository.findById(id);
            if ( optionalBookDetail.isPresent() ) {
                BookDetail update = optionalBookDetail.get();

                update.setBookAuthor("wang update");
                bookDetailRepository.save(update);
//                Hibernate:
//                update
//                        book
//                set
//                book_name=?
//                where
//                id=?

            }

        }


}
