package service;

import model.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICommentRepository;

import java.util.List;

public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
