package net.gitschthaler;

import net.gitschthaler.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface CommentRepo extends PagingAndSortingRepository<Comment,Long> {
    Page<Comment> findByArticleId(@Param("articleId") Long id, Pageable pageable);
    Page<Comment> findByArticleIdOrderByPath(@Param("articleId") Long id, Pageable pageable);
}