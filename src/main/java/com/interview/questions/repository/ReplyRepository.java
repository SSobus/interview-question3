package com.interview.questions.repository;

import com.interview.questions.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Reply Repository extends JpaRepository
 */
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
