package com.example.demo.repository;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class CommentsRepositoryTest {

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private MovieRepository movieRepository;
//
//    @Test
//    public void commList() {
//
//        List<Movie> list = movieRepository.findAll();
//        PageRequest pageRequest = PageRequest.of(1,5);
//        list.forEach(m->{
//            System.out.println(m.getMnum() + ", " + m.getTitle() + " ," + m.getContent() + " ," + m.getDirector());
//            System.out.println("<<댓글>>");
//            List<Comments> clist = commentsRepository.findByMnum(m.getMnum(),pageRequest);
//            clist.forEach(c->{
//                System.out.println(c.getCnum() + ", " + c.getId() + ", " + c.getComments());
//            });
//            System.out.println("-------------------");
//        });
//
//    }

}
