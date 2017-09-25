package com.example.demo.repository;

import com.example.demo.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pavel Gavrilov
 *         25.09.2017.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
