package repository;

import model.Comment;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class CommentRepository implements ICommentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query =  entityManager.createQuery("select c from Comment c where c.id = :id ", Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        if(comment.getId() != null) {
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }
    }
}
