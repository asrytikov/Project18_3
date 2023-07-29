package org.example;

import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);
        System.out.println(service.getClass());

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Alex");
        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
    }
}