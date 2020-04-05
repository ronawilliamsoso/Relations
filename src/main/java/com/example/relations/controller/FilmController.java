package com.example.relations.controller;


import com.example.relations.ManyToOne.Film;
import com.example.relations.ManyToOne.FilmComment;
import com.example.relations.onetoone.Book;
import com.example.relations.onetoone.BookDetail;
import com.example.relations.repository.BookDetailRepository;
import com.example.relations.repository.BookRepository;
import com.example.relations.repository.FilmCommentRepository;
import com.example.relations.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Wei
 * @date 04.04.20
 */

@RestController
@RequiredArgsConstructor
public class FilmController {
    private final FilmRepository filmRepository;
    private final FilmCommentRepository filmCommentRepository;

    @GetMapping( value = "/film/addFilm" )
    private void addFilme() {

        Film film = Film.builder().filmName("Loard of the rings").build();

        filmRepository.save(film);
//        Hibernate: insert   into  film   (film_name)  values  (?)

    }

    @GetMapping( value = "/film/addFilmCommentsToANewFilm" )
    private void addFilmCommentsToANewFilm() {

        Film film = filmRepository.save(Film.builder().filmName("The Hobbit").build());
//        Hibernate: insert   into  film  (film_name) values  (?)
        FilmComment filmComment1 = FilmComment.builder().commentText("Good").film(film).build();
        FilmComment filmComment2 = FilmComment.builder().commentText("So so").film(film).build();



        filmCommentRepository.save(filmComment1);
//        Hibernate:  insert   into   film_comment (comment_text, film_id)  values  (?, ?)

        filmCommentRepository.save(filmComment2);

//        Hibernate: insert    into  film_comment  (comment_text, film_id) values  (?, ?)


    }

    @GetMapping( value = "/film/addAFilmCommentToAnOldFilm" )
    private void addAFilmCommentToAnOldFilm(Integer filmId) {

        Optional<Film> optionalFilm = filmRepository.findById(filmId);
//        Hibernate:
//        select
//        film0_.film_id as film_id1_2_0_,
//                film0_.film_name as film_nam2_2_0_
//        from
//        film film0_
//        where
//        film0_.film_id=?
        if(optionalFilm.isPresent()){

            FilmComment filmComment = FilmComment.builder().commentText("add a new comment to the old one").film(optionalFilm.get()).build();
            filmCommentRepository.save(filmComment);
           // Hibernate:  insert   into film_comment   (comment_text, film_id) values   (?, ?)
        }

    }

    @DeleteMapping( value = "/film/deleteAFilmComment" )
    private void deleteAFilmComment(Integer filmCommenId) {

        Optional<FilmComment> optionalFilmComment = filmCommentRepository.findById(filmCommenId);
//        Hibernate:
//        select
//        filmcommen0_.comment_id as comment_1_3_0_,
//                filmcommen0_.comment_text as comment_2_3_0_,
//        filmcommen0_.film_id as film_id3_3_0_
//                from
//        film_comment filmcommen0_
//        where
//        filmcommen0_.comment_id=?
//
//
//        Hibernate:
//        select
//        film0_.film_id as film_id1_2_0_,
//                film0_.film_name as film_nam2_2_0_
//        from
//        film film0_
//        where
//        film0_.film_id=?
        if(optionalFilmComment.isPresent()){

            filmCommentRepository.deleteById(filmCommenId);
            //Hibernate:   delete  from  film_comment   where comment_id=?
        }

    }

    @DeleteMapping( value = "/film/deleteAFilmWithDirectlyWillFail" )
    private void deleteAFilmDirectlyWillFail(Integer filmId) {

        Optional<Film> optionalFilm = filmRepository.findById(filmId);
//        Hibernate:
//        select
//        film0_.film_id as film_id1_2_0_,
//                film0_.film_name as film_nam2_2_0_
//        from
//        film film0_
//        where
//        film0_.film_id=?
        if(optionalFilm.isPresent()){
            filmRepository.deleteById(filmId);
            //org.postgresql.util.PSQLException: ERROR: update or delete on table "film" violates foreign key constraint "fkfj3fuvpw09obvcpo2l6y1ionk" on table "film_comment"
        }

    }

    @DeleteMapping( value = "/film/rightWayToDeleteAFilm" )
    private void rightWayToDeleteAFilm(Integer filmId) {

        Optional<Film> optionalFilm = filmRepository.findById(filmId);
//        Hibernate:
//        select
//        film0_.film_id as film_id1_2_0_,
//                film0_.film_name as film_nam2_2_0_
//        from
//        film film0_
//        where
//        film0_.film_id=?
        if(optionalFilm.isPresent()){
            Example<FilmComment> example = Example.of(FilmComment.builder().film(optionalFilm.get()).build());

            List<FilmComment> comments = filmCommentRepository.findAll(example);
//            Hibernate:
//            select
//            filmcommen0_.comment_id as comment_1_3_,
//                    filmcommen0_.comment_text as comment_2_3_,
//            filmcommen0_.film_id as film_id3_3_
//                    from
//            film_comment filmcommen0_
//            inner join
//            film film1_
//            on filmcommen0_.film_id=film1_.film_id
//            where
//            film1_.film_id=1
//            and film1_.film_name=?


            filmCommentRepository.deleteAll(comments);

//            Hibernate:  delete   from film_comment     wherecomment_id=?
//            Hibernate:  delete   from film_comment   where  comment_id=?

            filmRepository.deleteById(filmId);

           // Hibernate:    delete  from film  where  film_id=?

        }


    }

    @GetMapping( value = "/film/updateAFilm" )
    private void updateAFilm(Integer filmId) {

        Optional<Film> optionalFilm = filmRepository.findById(filmId);
        if(optionalFilm.isPresent()){
            Film update = optionalFilm.get();
            update.setFilmName("updated film name");
            filmRepository.save(update);
//            Hibernate:  update      film  set  film_name=?  where film_id=?
        }
    }


    @GetMapping( value = "/film/updateAFilmComment" )
    private void updateAFilmComment(Integer filmCommentId) {


        Optional<FilmComment> optionalFilmComment = filmCommentRepository.findById(filmCommentId);

//        Hibernate:
//        select
//        filmcommen0_.comment_id as comment_1_3_0_,
//                filmcommen0_.comment_text as comment_2_3_0_,
//        filmcommen0_.film_id as film_id3_3_0_
//                from
//        film_comment filmcommen0_
//        where
//        filmcommen0_.comment_id=?


//        Hibernate:
//        select
//        film0_.film_id as film_id1_2_0_,
//                film0_.film_name as film_nam2_2_0_
//        from
//        film film0_
//        where
//        film0_.film_id=?

        if(optionalFilmComment.isPresent()){
            FilmComment update = optionalFilmComment.get();
            update.setCommentText("updated comment: bad");

            filmCommentRepository.save(update);

           // Hibernate: update film_comment   set  comment_text=?, film_id=? where comment_id=?
        }
    }

    @GetMapping( value = "/film/searchAFilmComment" )
    private void searchAFilmComment(Integer filmCommentId) {

      filmCommentRepository.findById(filmCommentId);

//        Hibernate:
//        select
//        filmcommen0_.comment_id as comment_1_3_0_,
//                filmcommen0_.comment_text as comment_2_3_0_,
//        filmcommen0_.film_id as film_id3_3_0_
//                from
//        film_comment filmcommen0_
//        where
//        filmcommen0_.comment_id=?

    }

    @GetMapping( value = "/film/searchAFilm" )
    private void searchAFilm(Integer filmId) {

        filmRepository.findById(filmId);

    }


}
