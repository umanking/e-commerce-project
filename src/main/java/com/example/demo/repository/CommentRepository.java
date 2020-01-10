package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Geonguk Han
 * @since 2020-01-10
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
