package xyz.izmy.onlineedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.izmy.onlineedu.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findCommentById(Long id);
}
